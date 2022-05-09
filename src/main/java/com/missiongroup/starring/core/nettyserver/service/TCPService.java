package com.missiongroup.starring.core.nettyserver.service;

import com.missiongroup.starring.core.nettyserver.entity.Constants;
import com.missiongroup.starring.core.nettyserver.handler.TCPChildChannelHandler;
import org.apache.log4j.Logger;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class TCPService implements Runnable {
	private static final Logger logger = Logger.getLogger(TCPService.class);

	@Override
	public void run() {
		this.bind();
	}

	private void bind() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000);
			b.option(ChannelOption.TCP_NODELAY, true);
			b.option(ChannelOption.ALLOW_HALF_CLOSURE, true);
			b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
			b.childHandler(new TCPChildChannelHandler());
			b.childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(256, 1024 * 2048, 1024 * 2048));
			b.childOption(ChannelOption.SO_KEEPALIVE, true);
			ChannelFuture f = b.bind(Constants.Port).sync();
			logger.info("TELECONTROL_SERVER Started At Port " + Constants.Port + ".");
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}