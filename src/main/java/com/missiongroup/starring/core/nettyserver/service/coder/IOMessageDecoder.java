package com.missiongroup.starring.core.nettyserver.service.coder;

import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.core.cache.service.PortModel;
import com.missiongroup.starring.core.log.LogManager;
import com.missiongroup.starring.core.nettyserver.entity.IOMessage;
import com.missiongroup.starring.core.nettyserver.factory.IscsFactory;
import com.missiongroup.starring.core.nettyserver.utils.ByteUtil;
import com.missiongroup.starring.core.nettyserver.utils.CoderUtil;
import com.missiongroup.starring.core.util.SpringContextHolder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOMessageDecoder extends ByteToMessageDecoder {

	private final static int HEAD_FLAG = -5592148;
	private final static int END_FLAG = -4539460;
	private static final Logger logger = LoggerFactory.getLogger(IOMessageDecoder.class);
	private ICache iCaches = SpringContextHolder.getBean(ICache.class);

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf data, List<Object> out) {
		// 数据解密
		// String decrypt =
		// AESUtils.decrypt(AESUtils.byte2HexStr(CoderUtil.readBuffer(data)));
		// data = Unpooled.buffer().writeBytes(AESUtils.getHexBytes(decrypt));

		// logger.info("from[" + ctx.channel().remoteAddress() + "],length:" +
		// buffer.length + ",data:" + ByteUtil.getDataInfo(buffer));

        byte[] buffer = new byte[data.readableBytes()];
        data.readBytes(buffer);
		saveData(ByteUtil.getDataInfo(buffer));
        data.resetReaderIndex();

		IOMessage ioMessage = new IOMessage();
		// 消息头 3
		int hearFlag = data.readMedium();
		int readableBytes = data.readableBytes();
		ByteBuf byteBuf = data.readBytes(readableBytes - 3);
		int end_flag = data.readMedium();
		if (END_FLAG != end_flag) {
			data.resetReaderIndex();
			return;
		}
		if (hearFlag != HEAD_FLAG) {
			return;
		}
		ioMessage.setHeader(hearFlag);

		int packeLength = byteBuf.readableBytes() + 6;// 消息头和消息尾个三个字节
		logger.info("packeLength: " + packeLength);

		// 消息类型 1
		int type = byteBuf.readByte();
		ioMessage.setType(type);
		// 消息id(递增) 4
		int messageId = byteBuf.readInt();
		ioMessage.setMessageId(messageId);
		// 通信协议类型 1
		int protocol = byteBuf.readByte();
		ioMessage.setProtocol(protocol);
		// 通信协议版本号 1
		int version = byteBuf.readByte();
		ioMessage.setVersion(version);
		// 端口数据长度 4
		int dataLength = byteBuf.readInt();
		ioMessage.setDataLength(dataLength);
		// 城市id 1
		int cityId = byteBuf.readByte();
		ioMessage.setCityId(cityId);
		// 线路 1
		int line = byteBuf.readByte();
		ioMessage.setLine(line);

		// 编组 2
		short group = byteBuf.readShort();
		ioMessage.setGroup(group);

		// 设备ID
		int deviceId = byteBuf.readByte();
		ioMessage.setDeviceId(deviceId);

		// 日期（年）（比如 2016 填充 0x10）
		int year = byteBuf.readByte() + 2000;
		// 20 日期（月）
		int moon = byteBuf.readByte();
		// 21 日期（日）
		int day = byteBuf.readByte();
		// 22 时间（时）
		int hour = byteBuf.readByte();
		// 23 时间（分）
		int min = byteBuf.readByte();
		// 24 时间（秒）
		int second = byteBuf.readByte();
		// 毫秒
		short millisecond = byteBuf.readShort();
		String time = year + "-" + moon + "-" + day + " " + hour + ":" + min + ":" + second + " " + millisecond;
		ioMessage.setTime(time);
		// 端口数据类型
		int portDataType = byteBuf.readByte();
		ioMessage.setPortDataType(portDataType);
		// 预留
		byte[] reserve = new byte[7];
		byteBuf.readBytes(reserve);
		ioMessage.setReserve(reserve);

		// 每个端口是36个字节
		int ports = dataLength / 36;
		logger.info("receive ports: " + ports);
		Map<String, Map<String, PortModel>> portData = new HashMap<>();
		for (int i = 0; i < ports; i++) {
			ByteBuf portByteBuf = byteBuf.readBytes(36);
			String upper16 = Integer.toHexString(portByteBuf.readUnsignedByte());
			String low16 = Integer.toHexString(portByteBuf.readUnsignedByte());
			if (low16.length() == 1) {
				low16 = "0" + low16;
			}
			String portNum = upper16 + low16;
			String s = "port0x" + portNum.substring(1);
			Map dataCache = iCaches.get("CONSTANT", "portData");
			if (dataCache.containsKey(s)) {
				ArrayList o = (ArrayList) dataCache.get(s);
				Map<String, PortModel> object = CoderUtil.transform(portByteBuf, o);
				portData.put(s, object);
				
			}
			ReferenceCountUtil.release(portByteBuf);
		}

		ioMessage.setPortDatas(portData);

		// --------xw------------
		saveExternalPortData(ioMessage, year, moon, day, hour, min, second);
		// --------xw------------
	//	saveDoorData(ioMessage, year, moon, day, hour, min, second);

		byte[] check = new byte[2];
		byteBuf.readBytes(check);
		ioMessage.setCheck(check);
		ioMessage.setMessageEnd(end_flag);
		ReferenceCountUtil.release(byteBuf);
		out.add(ioMessage);
	}

	public static void saveExternalPortData(IOMessage ioMessage, int year, int moon, int day, int hour, int min,int second) {
		byte[] dataBytes = new byte[128];
		//列车设备通讯状态，0-故障，1-正常
		dataBytes[0] = (byte)(dataBytes[0] | 0x01);
		//year
		//Month
		//Date
		//Hour
		//Minute
		//Second
		dataBytes[1] = ByteUtil.itob(year - 2000);
		dataBytes[2] = ByteUtil.itob(moon);
		dataBytes[3] = ByteUtil.itob(day);
		dataBytes[4] = ByteUtil.itob(hour);
		dataBytes[5] = ByteUtil.itob(min);
		dataBytes[6] = ByteUtil.itob(second);
		//MPU_CTrainNumber
		String trainNum = getPortDateStringByMap(ioMessage, "port0x101", "MPU_CTrainNumber");
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(trainNum)),0,dataBytes,8,2);
		//PIS_CSerialNumber
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c1", "PIS_CSerialNumber"))),0,dataBytes,10,2);
		//PIS_CFinalDestination
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c1", "PIS_CFinalDestination"))),0,dataBytes,12,2);
		//PIS_CServiceNumber
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c1", "PIS_CServiceNumber"))),0,dataBytes,14,2);
		//ATC_CWorkingCond
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x173", "ATC_CWorkingCond"))){//0-离线
			dataBytes[16] = (byte)(dataBytes[16] | 0x01);
		}
		//DD_CFireInside
		//DD_CFireUnderFrame
		//DD_CFireFltHV_B1
		//DD_CFireFltHV_B2
		//DD_CFireFltLV_B1
		//DD_CFireFltLV_B2
		//DD_CFireHV_B1
		//DD_CFireHV_B2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireInside"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireUnderFrame"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireFltHV_B1"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireFltHV_B2"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireFltLV_B1"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireFltLV_B2"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireHV_B1"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireHV_B2"))){
			dataBytes[20] = (byte)(dataBytes[20] | 0x80);
		}
		//DD_CFireLV_B1
		//DD_CFireLV_B2
		//DD_CFireSaloon_A1
		//DD_CFireSaloon_A2
		//DD_CFireSaloon_B1
		//DD_CFireSaloon_B2
		//DD_CFireSaloon_C1
		//DD_CFireSaloon_C2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireLV_B1"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireLV_B2"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireSaloon_A1"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireSaloon_A2"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireSaloon_B1"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireSaloon_B2"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireSaloon_C1"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x120", "DD_CFireSaloon_C2"))){
			dataBytes[21] = (byte)(dataBytes[21] | 0x80);
		}
		//DD_CFireExt1_A1
		//DD_CFireExt2_A1
		//DD_CFireExt3_A1
		//DD_CFireExt4_A1
		//DD_CFireExt1_A2
		//DD_CFireExt2_A2
		//DD_CFireExt3_A2
		//DD_CFireExt4_A2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt1_A1"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt2_A1"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt3_A1"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt4_A1"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt1_A2"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt2_A2"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt3_A2"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt4_A2"))){
			dataBytes[22] = (byte)(dataBytes[22] | 0x80);
		}
		//DD_CFireExt1_B1
		//DD_CFireExt2_B1
		//DD_CFireExt3_B1
		//DD_CFireExt4_B1
		//DD_CFireExt1_B2
		//DD_CFireExt2_B2
		//DD_CFireExt3_B2
		//DD_CFireExt4_B2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt1_B1"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt2_B1"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt3_B1"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt4_B1"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt1_B2"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt2_B2"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt3_B2"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt4_B2"))){
			dataBytes[23] = (byte)(dataBytes[23] | 0x80);
		}
		//DD_CFireExt1_C1
		//DD_CFireExt2_C1
		//DD_CFireExt3_C1
		//DD_CFireExt1_C2
		//DD_CFireExt2_C2
		//DD_CFireExt3_C2
		//DD_CFireExt4_C2
		//DD_CFireBat_A1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt1_C1"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt2_C1"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt3_C1"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt1_C2"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt2_C2"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt3_C2"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireExt4_C2"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireBat_A1"))){
			dataBytes[24] = (byte)(dataBytes[24] | 0x80);
		}
		//DD_CFireBat_C2
		//DD_CFireBat_A2
		//DD_CFireCVS_A1
		//DD_CFireCVS_C1
		//DD_CFireCVS_A2
		//DD_CFireTraction_B1
		//DD_CFireTraction_C1
		//DD_CFireTraction_C2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireBat_C2"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireBat_A2"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireCVS_A1"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireCVS_C1"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireCVS_A2"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireTraction_B1"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireTraction_C1"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireTraction_C2"))){
			dataBytes[25] = (byte)(dataBytes[25] | 0x80);
		}
		//DD_CFireTraction_B2
		//DD_CSmokePreAlarm_A1
		//DD_CSmokePreAlarm_A2
		//DD_CSmokePreAlarm_B1
		//DD_CSmokePreAlarm_B2
		//DD_CSmokePreAlarm_C1
		//DD_CSmokePreAlarm_C2
		//DD_CSD_A1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CFireTraction_B2"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSmokePreAlarm_A1"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSmokePreAlarm_A2"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSmokePreAlarm_B1"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSmokePreAlarm_B2"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSmokePreAlarm_C1"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSmokePreAlarm_C2"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSD_A1"))){
			dataBytes[26] = (byte)(dataBytes[26] | 0x80);
		}
		//DD_CSD_A2
		//DD_CSD_B1
		//DD_CSD_B2
		//DD_CSD_C1
		//DD_CSD_C2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSD_A2"))){
			dataBytes[27] = (byte)(dataBytes[27] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSD_B1"))){
			dataBytes[27] = (byte)(dataBytes[27] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSD_B2"))){
			dataBytes[27] = (byte)(dataBytes[27] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSD_C1"))){
			dataBytes[27] = (byte)(dataBytes[27] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x123", "DD_CSD_C2"))){
			dataBytes[27] = (byte)(dataBytes[27] | 0x10);
		}
		//DD_CBMSLoadweight_A1
		//DD_CBMSLoadweight_A2
		//DD_CBMSLoadweight_B1
		//DD_CBMSLoadweight_B2
		//DD_CBMSLoadweight_C1
		//DD_CBMSLoadweight_C2
		dataBytes[32] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x137", "DD_CBMSLoadweight_A1")));
		dataBytes[33] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x137", "DD_CBMSLoadweight_A2")));
		dataBytes[34] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x137", "DD_CBMSLoadweight_B1")));
		dataBytes[35] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x137", "DD_CBMSLoadweight_B2")));
		dataBytes[36] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x137", "DD_CBMSLoadweight_C1")));
		dataBytes[37] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x137", "DD_CBMSLoadweight_C2")));
		//PIS_CPassengerLoad_A1
		//PIS_CPassengerLoad_B1
		//PIS_CPassengerLoad_C1
		//PIS_CPassengerLoad_C2
		//PIS_CPassengerLoad_B2
		//PIS_CPassengerLoad_A2
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c0", "PIS_CPassengerLoad_A1"))),0,dataBytes,38,2);
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c0", "PIS_CPassengerLoad_B1"))),0,dataBytes,40,2);
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c0", "PIS_CPassengerLoad_C1"))),0,dataBytes,42,2);
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c0", "PIS_CPassengerLoad_C2"))),0,dataBytes,44,2);
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c0", "PIS_CPassengerLoad_B2"))),0,dataBytes,46,2);
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x1c0", "PIS_CPassengerLoad_A2"))),0,dataBytes,48,2);
		//PMS_ITempCls1Alarm
		//PMS_ICatOffCls1Alarm
		//PMS_ICatHeiCls1Alarm
		//PMS_IArcCls1Alarm
		//PMS_IStrCls1Alarm
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x950", "PMS_ITempCls1Alarm"))){
			dataBytes[55] = (byte)(dataBytes[55] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x950", "PMS_ICatOffCls1Alarm"))){
			dataBytes[55] = (byte)(dataBytes[55] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x950", "PMS_ICatHeiCls1Alarm"))){
			dataBytes[55] = (byte)(dataBytes[55] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x950", "PMS_IArcCls1Alarm"))){
			dataBytes[55] = (byte)(dataBytes[55] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x950", "PMS_IStrCls1Alarm"))){
			dataBytes[55] = (byte)(dataBytes[55] | 0x10);
		}
		//DD_CTrainHVVolt
		System.arraycopy(ByteUtil.int16TobyteArray2(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x120", "DD_CTrainHVVolt"))),0,dataBytes,56,2);
		//DD_CHVSPantoRaised_B1
		//DD_CHVSPantoRaised_B2
		//DD_CHVSPantoRaisedHV_B1
		//DD_CHVSPantoRaisedHV_B2
		//DD_CHVSPantoLoweredSts_B1
		//DD_CHVSPantoLoweredSts_B2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x127", "DD_CHVSPantoRaised_B1"))){
			dataBytes[58] = (byte)(dataBytes[58] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x127", "DD_CHVSPantoRaised_B2"))){
			dataBytes[58] = (byte)(dataBytes[58] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x127", "DD_CHVSPantoRaisedHV_B1"))){
			dataBytes[58] = (byte)(dataBytes[58] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x127", "DD_CHVSPantoRaisedHV_B2"))){
			dataBytes[58] = (byte)(dataBytes[58] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x127", "DD_CHVSPantoLoweredSts_B1"))){
			dataBytes[58] = (byte)(dataBytes[58] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x127", "DD_CHVSPantoLoweredSts_B2"))){
			dataBytes[58] = (byte)(dataBytes[58] | 0x40);
		}

		//DD_CDrsIsol1_A1,DD_CDrsCommOk1_A1
		//DD_CDrsIsol3_A1,DD_CDrsCommOk3_A1
		//DD_CDrsIsol5_A1,DD_CDrsCommOk5_A1
		//DD_CDrsIsol7_A1,DD_CDrsCommOk7_A1
		//DD_CDrsIsol1_B1,DD_CDrsCommOk1_B1
		//DD_CDrsIsol3_B1,DD_CDrsCommOk3_B1
		//DD_CDrsIsol5_B1,DD_CDrsCommOk5_B1
		//DD_CDrsIsol7_B1,DD_CDrsCommOk7_B1
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol1_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk1_A1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol3_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk3_A1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol5_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk5_A1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol7_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk7_A1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol1_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk1_B1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol3_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk3_B1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol5_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk5_B1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol7_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk7_B1"))){
			dataBytes[61] = (byte)(dataBytes[61] | 0x80);
		}

		//DD_CDrsIsol1_C1,DD_CDrsCommOk1_C1
		//DD_CDrsIsol3_C1,DD_CDrsCommOk3_C1
		//DD_CDrsIsol5_C1,DD_CDrsCommOk5_C1
		//DD_CDrsIsol7_C1,DD_CDrsCommOk7_C1
		//DD_CDrsIsol8_C2,DD_CDrsCommOk8_C2
		//DD_CDrsIsol6_C2,DD_CDrsCommOk6_C2
		//DD_CDrsIsol4_C2,DD_CDrsCommOk4_C2
		//DD_CDrsIsol2_C2,DD_CDrsCommOk2_C2
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol1_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk1_C1"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol3_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk3_C1"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol5_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk5_C1"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol7_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk7_C1"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol8_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk8_C2"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol6_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk6_C2"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol4_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk4_C2"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol2_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk2_C2"))){
			dataBytes[62] = (byte)(dataBytes[62] | 0x80);
		}

		//DD_CDrsIsol8_B2,DD_CDrsCommOk8_B2
		//DD_CDrsIsol6_B2,DD_CDrsCommOk6_B2
		//DD_CDrsIsol4_B2,DD_CDrsCommOk4_B2
		//DD_CDrsIsol2_B2,DD_CDrsCommOk2_B2
		//DD_CDrsIsol8_A2,DD_CDrsCommOk8_A2
		//DD_CDrsIsol6_A2,DD_CDrsCommOk6_A2
		//DD_CDrsIsol4_A2,DD_CDrsCommOk4_A2
		//DD_CDrsIsol2_A2,DD_CDrsCommOk2_A2
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol8_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk8_B2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol6_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk6_B2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol4_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk4_B2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol2_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk2_B2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol8_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk8_A2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol6_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk6_A2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol4_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk4_A2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol2_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk2_A2"))){
			dataBytes[63] = (byte)(dataBytes[63] | 0x80);
		}

		//DD_CDrsIsol8_B1,DD_CDrsCommOk8_B1
		//DD_CDrsIsol6_B1,DD_CDrsCommOk6_B1
		//DD_CDrsIsol4_B1,DD_CDrsCommOk4_B1
		//DD_CDrsIsol2_B1,DD_CDrsCommOk2_B1
		//DD_CDrsIsol8_A1,DD_CDrsCommOk8_A1
		//DD_CDrsIsol6_A1,DD_CDrsCommOk6_A1
		//DD_CDrsIsol4_A1,DD_CDrsCommOk4_A1
		//DD_CDrsIsol2_A1,DD_CDrsCommOk2_A1
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol8_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk8_B1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol6_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk6_B1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol4_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk4_B1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol2_B1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk2_B1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol8_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk8_A1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol6_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk6_A1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol4_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk4_A1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol2_A1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk2_A1"))){
			dataBytes[64] = (byte)(dataBytes[64] | 0x80);
		}

		//DD_CDrsIsol1_C2,DD_CDrsCommOk1_C2
		//DD_CDrsIsol3_C2,DD_CDrsCommOk3_C2
		//DD_CDrsIsol5_C2,DD_CDrsCommOk5_C2
		//DD_CDrsIsol7_C2,DD_CDrsCommOk7_C2
		//DD_CDrsIsol8_C1,DD_CDrsCommOk8_C1
		//DD_CDrsIsol6_C1,DD_CDrsCommOk6_C1
		//DD_CDrsIsol4_C1,DD_CDrsCommOk4_C1
		//DD_CDrsIsol2_C1,DD_CDrsCommOk2_C1
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol1_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk1_C2"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol3_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk3_C2"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol5_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk5_C2"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol7_C2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk7_C2"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol8_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk8_C1"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol6_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk6_C1"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol4_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk4_C1"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol2_C1"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk2_C1"))){
			dataBytes[65] = (byte)(dataBytes[65] | 0x80);
		}

		//DD_CDrsIsol1_A2,DD_CDrsCommOk1_A2
		//DD_CDrsIsol3_A2,DD_CDrsCommOk3_A2
		//DD_CDrsIsol5_A2,DD_CDrsCommOk5_A2
		//DD_CDrsIsol7_A2,DD_CDrsCommOk7_A2
		//DD_CDrsIsol1_B2,DD_CDrsCommOk1_B2
		//DD_CDrsIsol3_B2,DD_CDrsCommOk3_B2
		//DD_CDrsIsol5_B2,DD_CDrsCommOk5_B2
		//DD_CDrsIsol7_B2,DD_CDrsCommOk7_B2
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol1_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk1_A2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol3_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk3_A2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol5_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk5_A2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol7_A2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk7_A2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol1_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk1_B2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol3_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk3_B2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol5_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk5_B2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsol7_B2"))
				&& "1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsCommOk7_B2"))){
			dataBytes[66] = (byte)(dataBytes[66] | 0x80);
		}

		//DD_CDrsIsolEle1_A1
		//DD_CDrsIsolEle3_A1
		//DD_CDrsIsolEle5_A1
		//DD_CDrsIsolEle7_A1
		//DD_CDrsIsolEle1_B1
		//DD_CDrsIsolEle3_B1
		//DD_CDrsIsolEle5_B1
		//DD_CDrsIsolEle7_B1
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle1_A1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle3_A1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle5_A1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle7_A1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle1_B1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle3_B1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle5_B1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle7_B1"))){
			dataBytes[67] = (byte)(dataBytes[67] | 0x80);
		}

		//DD_CDrsIsolEle1_C1
		//DD_CDrsIsolEle3_C1
		//DD_CDrsIsolEle5_C1
		//DD_CDrsIsolEle7_C1
		//DD_CDrsIsolEle8_C2
		//DD_CDrsIsolEle6_C2
		//DD_CDrsIsolEle4_C2
		//DD_CDrsIsolEle2_C2
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle1_C1"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle3_C1"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle5_C1"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle7_C1"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle8_C2"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle6_C2"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle4_C2"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle2_C2"))){
			dataBytes[68] = (byte)(dataBytes[68] | 0x80);
		}

		//DD_CDrsIsolEle8_B2
		//DD_CDrsIsolEle6_B2
		//DD_CDrsIsolEle4_B2
		//DD_CDrsIsolEle2_B2
		//DD_CDrsIsolEle8_A2
		//DD_CDrsIsolEle6_A2
		//DD_CDrsIsolEle4_A2
		//DD_CDrsIsolEle2_A2
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle8_B2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle6_B2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle4_B2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle2_B2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle8_A2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle6_A2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle4_A2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle2_A2"))){
			dataBytes[69] = (byte)(dataBytes[69] | 0x80);
		}

		//DD_CDrsIsolEle8_B1
		//DD_CDrsIsolEle6_B1
		//DD_CDrsIsolEle4_B1
		//DD_CDrsIsolEle2_B1
		//DD_CDrsIsolEle8_A1
		//DD_CDrsIsolEle6_A1
		//DD_CDrsIsolEle4_A1
		//DD_CDrsIsolEle2_A1
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle8_B1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle6_B1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle4_B1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle2_B1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle8_A1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle6_A1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle4_A1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle2_A1"))){
			dataBytes[70] = (byte)(dataBytes[70] | 0x80);
		}

		//DD_CDrsIsolEle1_C2
		//DD_CDrsIsolEle3_C2
		//DD_CDrsIsolEle5_C2
		//DD_CDrsIsolEle7_C2
		//DD_CDrsIsolEle8_C1
		//DD_CDrsIsolEle6_C1
		//DD_CDrsIsolEle4_C1
		//DD_CDrsIsolEle2_C1
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle1_C2"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle3_C2"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle5_C2"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle7_C2"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle8_C1"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle6_C1"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle4_C1"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle2_C1"))){
			dataBytes[71] = (byte)(dataBytes[71] | 0x80);
		}

		//DD_CDrsIsolEle1_A2
		//DD_CDrsIsolEle3_A2
		//DD_CDrsIsolEle5_A2
		//DD_CDrsIsolEle7_A2
		//DD_CDrsIsolEle1_B2
		//DD_CDrsIsolEle3_B2
		//DD_CDrsIsolEle5_B2
		//DD_CDrsIsolEle7_B2
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle1_A2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x01);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle3_A2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x02);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle5_A2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x04);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle7_A2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x08);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle1_B2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x10);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle3_B2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x20);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle5_B2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x40);
		}
		if("1".equals(getPortDateStringByMap(ioMessage, "port0x122", "DD_CDrsIsolEle7_B2"))){
			dataBytes[72] = (byte)(dataBytes[72] | 0x80);
		}




		/*//ATC_CDoorIsoLeftA1B1
		//ATC_CDoorIsoLeftC1C2
		//ATC_CDoorIsoLeftB2A2
		//ATC_CDoorIsoRightA1B1
		//ATC_CDoorIsoRightC1C2
		//ATC_CDoorIsoRightB2A2
		//<ATCi>_IDoorInhibLeftA1B1
		//<ATCi>_IDoorInhibLeftC1C2
		//<ATCi>_IDoorInhibLeftB2A2
		//<ATCi>_IDoorInhibRightA1B1
		//<ATCi>_IDoorInhibRightC1C2
		//<ATCi>_IDoorInhibRightB2A2
		dataBytes[61] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x173", "ATC_CDoorIsoLeftA1B1")));
		dataBytes[62] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x173", "ATC_CDoorIsoLeftC1C2")));
		dataBytes[63] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x173", "ATC_CDoorIsoLeftB2A2")));
		dataBytes[64] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x173", "ATC_CDoorIsoRightA1B1")));
		dataBytes[65] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x173", "ATC_CDoorIsoRightC1C2")));
		dataBytes[66] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x173", "ATC_CDoorIsoRightB2A2")));
		dataBytes[67] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x683", "<ATCi>_IDoorInhibLeftA1B1")));
		dataBytes[68] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x683", "<ATCi>_IDoorInhibLeftC1C2")));
		dataBytes[69] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x683", "<ATCi>_IDoorInhibLeftB2A2")));
		dataBytes[70] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x683", "<ATCi>_IDoorInhibRightA1B1")));
		dataBytes[71] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x683", "<ATCi>_IDoorInhibRightC1C2")));
		dataBytes[72] = ByteUtil.itob(Integer.valueOf(getPortDateStringByMap(ioMessage, "port0x683", "<ATCi>_IDoorInhibRightB2A2")));*/


		//DD_CDrsOpened1_A1
		//DD_CDrsOpened2_A1
		//DD_CDrsOpened3_A1
		//DD_CDrsOpened4_A1
		//DD_CDrsOpened5_A1
		//DD_CDrsOpened6_A1
		//DD_CDrsOpened7_A1
		//DD_CDrsOpened8_A1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened1_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened2_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened3_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened4_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened5_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened6_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened7_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened8_A1"))){
			dataBytes[73] = (byte)(dataBytes[73] | 0x80);
		}
		//DD_CDrsOpened1_B1
		//DD_CDrsOpened2_B1
		//DD_CDrsOpened3_B1
		//DD_CDrsOpened4_B1
		//DD_CDrsOpened5_B1
		//DD_CDrsOpened6_B1
		//DD_CDrsOpened7_B1
		//DD_CDrsOpened8_B1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened1_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened2_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened3_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened4_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened5_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened6_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened7_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened8_B1"))){
			dataBytes[74] = (byte)(dataBytes[74] | 0x80);
		}
		//DD_CDrsOpened1_C1
		//DD_CDrsOpened2_C1
		//DD_CDrsOpened3_C1
		//DD_CDrsOpened4_C1
		//DD_CDrsOpened5_C1
		//DD_CDrsOpened6_C1
		//DD_CDrsOpened7_C1
		//DD_CDrsOpened8_C1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened1_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened2_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened3_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened4_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened5_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened6_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened7_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened8_C1"))){
			dataBytes[75] = (byte)(dataBytes[75] | 0x80);
		}
		//DD_CDrsOpened1_C2
		//DD_CDrsOpened2_C2
		//DD_CDrsOpened3_C2
		//DD_CDrsOpened4_C2
		//DD_CDrsOpened5_C2
		//DD_CDrsOpened6_C2
		//DD_CDrsOpened7_C2
		//DD_CDrsOpened8_C2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened1_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened2_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened3_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened4_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened5_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened6_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened7_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened8_C2"))){
			dataBytes[76] = (byte)(dataBytes[76] | 0x80);
		}
		//DD_CDrsOpened1_B2
		//DD_CDrsOpened2_B2
		//DD_CDrsOpened3_B2
		//DD_CDrsOpened4_B2
		//DD_CDrsOpened5_B2
		//DD_CDrsOpened6_B2
		//DD_CDrsOpened7_B2
		//DD_CDrsOpened8_B2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened1_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened2_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened3_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened4_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened5_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened6_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened7_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened8_B2"))){
			dataBytes[77] = (byte)(dataBytes[77] | 0x80);
		}
		//DD_CDrsOpened1_A2
		//DD_CDrsOpened2_A2
		//DD_CDrsOpened3_A2
		//DD_CDrsOpened4_A2
		//DD_CDrsOpened5_A2
		//DD_CDrsOpened6_A2
		//DD_CDrsOpened7_A2
		//DD_CDrsOpened8_A2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened1_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened2_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened3_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened4_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened5_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened6_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened7_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsOpened8_A2"))){
			dataBytes[78] = (byte)(dataBytes[78] | 0x80);
		}
		//DD_CDrsClosed1_A1
		//DD_CDrsClosed2_A1
		//DD_CDrsClosed3_A1
		//DD_CDrsClosed4_A1
		//DD_CDrsClosed5_A1
		//DD_CDrsClosed6_A1
		//DD_CDrsClosed7_A1
		//DD_CDrsClosed8_A1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed1_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed2_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed3_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed4_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed5_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed6_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed7_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed8_A1"))){
			dataBytes[79] = (byte)(dataBytes[79] | 0x80);
		}
		//DD_CDrsClosed1_B1
		//DD_CDrsClosed2_B1
		//DD_CDrsClosed3_B1
		//DD_CDrsClosed4_B1
		//DD_CDrsClosed5_B1
		//DD_CDrsClosed6_B1
		//DD_CDrsClosed7_B1
		//DD_CDrsClosed8_B1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed1_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed2_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed3_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed4_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed5_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed6_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed7_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed8_B1"))){
			dataBytes[80] = (byte)(dataBytes[80] | 0x80);
		}
		//DD_CDrsClosed1_C1
		//DD_CDrsClosed2_C1
		//DD_CDrsClosed3_C1
		//DD_CDrsClosed4_C1
		//DD_CDrsClosed5_C1
		//DD_CDrsClosed6_C1
		//DD_CDrsClosed7_C1
		//DD_CDrsClosed8_C1
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed1_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed2_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed3_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed4_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed5_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed6_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed7_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed8_C1"))){
			dataBytes[81] = (byte)(dataBytes[81] | 0x81);
		}
		//DD_CDrsClosed1_C2
		//DD_CDrsClosed2_C2
		//DD_CDrsClosed3_C2
		//DD_CDrsClosed4_C2
		//DD_CDrsClosed5_C2
		//DD_CDrsClosed6_C2
		//DD_CDrsClosed7_C2
		//DD_CDrsClosed8_C2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed1_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed2_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed3_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed4_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed5_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed6_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed7_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed8_C2"))){
			dataBytes[82] = (byte)(dataBytes[82] | 0x82);
		}
		//DD_CDrsClosed1_B2
		//DD_CDrsClosed2_B2
		//DD_CDrsClosed3_B2
		//DD_CDrsClosed4_B2
		//DD_CDrsClosed5_B2
		//DD_CDrsClosed6_B2
		//DD_CDrsClosed7_B2
		//DD_CDrsClosed8_B2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed1_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed2_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed3_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed4_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed5_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed6_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed7_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed8_B2"))){
			dataBytes[83] = (byte)(dataBytes[83] | 0x82);
		}
		//DD_CDrsClosed1_A2
		//DD_CDrsClosed2_A2
		//DD_CDrsClosed3_A2
		//DD_CDrsClosed4_A2
		//DD_CDrsClosed5_A2
		//DD_CDrsClosed6_A2
		//DD_CDrsClosed7_A2
		//DD_CDrsClosed8_A2
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed1_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x01);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed2_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x02);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed3_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x04);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed4_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x08);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed5_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x10);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed6_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x20);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed7_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x40);
		}
		if(!"0".equals(getPortDateStringByMap(ioMessage, "port0x121", "DD_CDrsClosed8_A2"))){
			dataBytes[84] = (byte)(dataBytes[84] | 0x82);
		}
		//入库
		LogManager.me().executeLog(IscsFactory.IscsData(ByteUtil.byteArrayToHexStr(dataBytes),trainNum));


	}
	public static void saveDoorData(IOMessage ioMessage, int year, int moon, int day, int hour, int min,int second) {
		//
		boolean isFileExist = false;
		StringBuffer heads = new StringBuffer();
		StringBuffer values = new StringBuffer();
		String fileName = ioMessage.getTime().split("\\s")[0];
		File file = new File("data/" + fileName + ".csv");
		try {
			if (file.exists()) {
				isFileExist = true;
			}
			else {
//				File dir = new File("data");
//				if (!dir.exists()) { //用来测试此路径名表示的文件或目录是否存在
//					dir.mkdirs(); //来判断这是不是一个文件夹。
//				}
//				file.createNewFile();
				heads.append("time,");
			}
			
			values.append(ioMessage.getTime()).append(",");
			
			boolean b0=getPortKeyAndData(ioMessage.getPortDatas(), "port0x990", heads, values, isFileExist);
			
			boolean b1=getPortKeyAndData(ioMessage.getPortDatas(), "port0x991", heads, values, isFileExist);
			boolean b2=getPortKeyAndData(ioMessage.getPortDatas(), "port0x992", heads, values, isFileExist);
			boolean b3=getPortKeyAndData(ioMessage.getPortDatas(), "port0x993", heads, values, isFileExist);
			if(!b0  || !b1 || !b2 || !b3){
				return;
			}
			if(!isFileExist) {
				File dir = new File("data");
				if (!dir.exists()) { //用来测试此路径名表示的文件或目录是否存在
					dir.mkdirs(); //来判断这是不是一个文件夹。
				}
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			
			if(values.length()>0){
				values.deleteCharAt(values.length() - 1);
			}
			if(!isFileExist) {
				File dir = new File("data");
				if (!dir.exists()) { //用来测试此路径名表示的文件或目录是否存在
					dir.mkdirs(); //来判断这是不是一个文件夹。
				}
				file.createNewFile();
				
				
				if(heads.length()>0){
					heads.deleteCharAt(heads.length() - 1);
					fw.write(heads.toString());
					fw.write("\n");
				}
				
			}
			fw.write(values.toString());
			fw.write("\n");
			fw.close();
		}
		catch (IOException e) {
			logger.error("文件操作失败", e);
		}
	}
	
	private static boolean getPortKeyAndData(Map portDatas, String port, StringBuffer heads, StringBuffer values, boolean isFileExist) {
		Map<String, PortModel> portModelMap = (Map<String, PortModel>) portDatas.get(port);
		if(portModelMap ==null || portModelMap.isEmpty()){
			return false;
		}
		for (Map.Entry<String, PortModel> entryPortModelMap : portModelMap.entrySet()) {
			if(entryPortModelMap.getKey().equals("portStatus")){
				continue;
			}
			if(!isFileExist) {
				heads.append(entryPortModelMap.getKey()).append(",");
			}
			values.append(entryPortModelMap.getValue().getValue()).append(",");
		}
		return true;
	}
		
		private static String
		getPortDateStringByMap(IOMessage ioMessage, String portData, String portModelMapKey) {
		Map<String, PortModel> portModelMap = (Map<String, PortModel>) ioMessage.getPortDatas().get(portData);
		if(null != portModelMap) {
			for (Map.Entry<String, PortModel> entryPortModelMap : portModelMap.entrySet()) {
				if (entryPortModelMap.getKey().endsWith(portModelMapKey)) {
					return String.valueOf(entryPortModelMap.getValue().getValue());
				}
			}
		}else {
			logger.info(">>>"+portData);
		}
		return "0";
	}
	

    public static void saveData(String data) {
        logger.info("当前数据为：" + data);
//        try {
//            boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
//            File fout = isWindows ? new File("E:/data/data.txt") : new File("/home/mission/data/data.txt");
//            FileWriter fw = new FileWriter(fout, true);
//            PrintWriter pw = new PrintWriter(fw);
//            pw.println(data);
//            pw.flush();
//            fw.flush();
//            pw.close();
//            fw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}