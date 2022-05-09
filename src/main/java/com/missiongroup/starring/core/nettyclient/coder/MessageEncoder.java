package com.missiongroup.starring.core.nettyclient.coder;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.missiongroup.starring.core.nettyclient.entity.IOMessage;
import com.missiongroup.starring.core.nettyclient.util.MD5Util;
import com.missiongroup.starring.core.nettyclient.util.Utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<IOMessage> {
	private static final Logger logger = LoggerFactory.getLogger(MessageEncoder.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, IOMessage msg, ByteBuf out) throws Exception {
		// 包长度 四位
		int temp0 = msg.getPackageLength();
		byte[] packageLength = Utils.intToByte(temp0, 4);

		// 消息类型码 两位
		short temp1 = msg.getOperaCode();
		byte[] operaCode = Utils.shortToByte(temp1);

		// 会话流水号
		int temp2 = msg.getUuid();
		byte[] requestId = Utils.intToByte(temp2, 4);

		// 请求/应答标志 0x00：请求消息；0x01：应答消息
		int temp3 = msg.getFlag();
		byte[] flag = Utils.intToByte(temp3, 1);

		// Xml路径数据定义
		String temp4 = msg.getPath();
		byte[] xmlPath = temp4.getBytes();

		// 路径长度(感觉不需要)
		int temp5 = msg.getPathLength();
		byte[] xmlPathLength = Utils.intToByte(temp5, 4);

		// 消息报文版本
		int temp6 = msg.getVersion();
		byte[] version = Utils.intToByte(temp6, 1);

		// 应答码 对于请求消息，默认为0；
		int temp7 = msg.getResponseCode();
		byte[] responseCode = Utils.intToByte(temp7, 1);

		// 包体内容
		String temp8 = msg.getPackageContent();
		byte[] packageContent = temp8.getBytes("UTF-8");
		if (temp1 != 1) {
			logger.info("请求消息类型码：" + temp1);
			logger.info("请求会话号：" + temp2);
			logger.info("请求路径内容：" + temp4);
			logger.info("请求包体内容：" + temp8);
		}
		// 包转成byte[]
		LinkedList<byte[]> contents = new LinkedList<byte[]>();

		contents.add(operaCode);
		contents.add(requestId);
		contents.add(flag);
		contents.add(xmlPathLength);
		contents.add(xmlPath);
		contents.add(version);
		contents.add(responseCode);
		contents.add(packageContent);
		Utils.byteMerger(contents);
		String md5Str = Utils.md5Encoder(contents.get(0));
		contents.addFirst(packageLength);// 包长度要放在首位发过去但不放入md5校验，协议定的
		// 依毛从涛要求修改
		contents.add(MD5Util.getMD516Byte(md5Str));
		Utils.byteMerger(contents);
		out.writeBytes(contents.get(0));
		ctx.flush();
	}

}
