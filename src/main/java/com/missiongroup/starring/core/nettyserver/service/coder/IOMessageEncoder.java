package com.missiongroup.starring.core.nettyserver.service.coder;

import com.missiongroup.starring.core.nettyserver.entity.IOMessage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class IOMessageEncoder extends MessageToByteEncoder<IOMessage> {
	@Override
	protected void encode(ChannelHandlerContext ctx, IOMessage msg, ByteBuf out) {

			//ctx.flush();

	}
}