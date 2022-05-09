package com.missiongroup.starring.core.nettyclient.listener;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.missiongroup.starring.core.nettyclient.NettyClientBootStrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;

public class ConnectionListener implements ChannelFutureListener {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionListener.class);
	
	private NettyClientBootStrap client;
	
	public ConnectionListener(NettyClientBootStrap client) {
		this.client = client;
	}

	@Override
	public void operationComplete(ChannelFuture future) throws Exception {
		if (!future.isSuccess()) {
			logger.info("reconnecting...");
			final EventLoop loop = future.channel().eventLoop();
			loop.schedule(new Runnable() {

				@Override
				public void run() {
					try {
						client.reconnect();
					} catch (InterruptedException e) {
						logger.error("reconnect failed:" + e.getMessage());
					} catch (Exception e) {
						logger.error("reconnect failed:" + e.getMessage());
					}
				}
			}, 1L, TimeUnit.SECONDS);
		}
	}
}
