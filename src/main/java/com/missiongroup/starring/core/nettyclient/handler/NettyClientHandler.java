package com.missiongroup.starring.core.nettyclient.handler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.missiongroup.starring.core.nettyclient.ClientNetService;
import com.missiongroup.starring.core.nettyclient.NettyClientBootStrap;
import com.missiongroup.starring.core.nettyclient.entity.Command;
import com.missiongroup.starring.core.nettyclient.entity.IOMessage;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

@Sharable
public class NettyClientHandler extends SimpleChannelInboundHandler<IOMessage> {

	private static final Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);

	private NettyClientBootStrap client;

	public NettyClientHandler(NettyClientBootStrap client) {
		this.client = client;
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("_Server Disconnected.");
		EventLoop loop = ctx.channel().eventLoop();
		loop.schedule(new Runnable() {

			@Override
			public void run() {
				try {
					logger.info("_Server reconnecting ...");
					if (client.getSocketChannel() == null || !client.getSocketChannel().isActive()) {
						client.reconnect();
					}
				} catch (InterruptedException e) {
					logger.error("_Server reconnect failed:" + e.getMessage());
				} catch (Exception e) {
					logger.error("_Server reconnect failed:" + e.getMessage());
				}

			}
		}, 2L, TimeUnit.SECONDS);
		super.channelInactive(ctx);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IOMessage msg) throws Exception {
		ClientNetService.receiveMessage = msg;
		ClientNetService.latch.countDown();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			switch (e.state()) {
			case WRITER_IDLE:
				IOMessage ioMessage = new IOMessage(Command.HEARTBEAT_MSG, "", "");
				ctx.writeAndFlush(ioMessage);
				logger.info("Send Ping To Server...");
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.info("Server Disconnected.");
		cause.printStackTrace();
		if (ClientNetService.guardListenerThread.getConnectListenerThread() != null) {
			ClientNetService.guardListenerThread.getConnectListenerThread().setConnected(false);
		}
	}

}
