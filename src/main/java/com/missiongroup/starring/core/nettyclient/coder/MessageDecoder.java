package com.missiongroup.starring.core.nettyclient.coder;

import java.util.List;

import com.missiongroup.starring.core.nettyclient.entity.IOMessage;
import com.missiongroup.starring.core.nettyclient.util.Utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MessageDecoder extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
		if (byteBuf == null || byteBuf.readableBytes() <= 17) {
			return;
		}
		byteBuf.markReaderIndex();

		int packageLength = byteBuf.readInt();
		if (byteBuf.readableBytes() < packageLength) {
			byteBuf.resetReaderIndex();
			return;
		}
		short operaCode = byteBuf.readShort();
		int uuid = byteBuf.readInt();
		int flag = byteBuf.readByte();
		int pathLength = byteBuf.readInt();
		
		byte[] pathTemp = new byte[pathLength];
		byteBuf.readBytes(pathTemp);
		String path = new String(pathTemp, "UTF-8");

		int version = byteBuf.readByte();
		int responseCode = byteBuf.readByte();

		byte[] bodyTemp = new byte[packageLength - 13 - pathLength - 16];
		byteBuf.readBytes(bodyTemp);
		String packageContent = new String(bodyTemp, "UTF-8");

		byte[] md5Temp = new byte[16];
		byteBuf.readBytes(md5Temp);
		String md5 = Utils.bytes2HexString(md5Temp);

		IOMessage message = new IOMessage();
		message.setPackageLength(packageLength);
		message.setFlag(flag);
		message.setOperaCode(operaCode);
		message.setUuid(uuid);
		message.setPathLength(pathLength);
		message.setPath(path);
		message.setResponseCode(responseCode);
		message.setPackageContent(packageContent);
		message.setVersion(version);
		message.setMD5(md5);
		if (!message.getMD5().equals(message.generateMD5().toUpperCase())) {
			return;
		} else {
			if (message.getOperaCode() != 2) {
				System.out.println("========收到返回:" + message.getPackageContent() + "=====");
				out.add(message);
			}
		}
	}

}