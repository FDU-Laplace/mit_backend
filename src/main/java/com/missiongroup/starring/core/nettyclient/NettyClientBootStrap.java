package com.missiongroup.starring.core.nettyclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.missiongroup.starring.core.nettyclient.coder.MessageDecoder;
import com.missiongroup.starring.core.nettyclient.coder.MessageEncoder;
import com.missiongroup.starring.core.nettyclient.handler.NettyClientHandler;
import com.missiongroup.starring.core.nettyclient.listener.ConnectionListener;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyClientBootStrap {

	private static final Logger logger = LoggerFactory.getLogger(NettyClientBootStrap.class);

	private String host;

	private int port;

	public static SocketChannel socketChannel = null;

	private EventLoopGroup eventLoopGroup;

	private Bootstrap bootstrap;

	private NettyClientHandler handler;

	public NettyClientBootStrap(String host, int port) throws InterruptedException {
		this.host = host;
		this.port = port;
		start();
	}

	public void start() throws InterruptedException {
		handler = new NettyClientHandler(this);
		eventLoopGroup = new NioEventLoopGroup();
		bootstrap = new Bootstrap();

		bootstrap.channel(NioSocketChannel.class);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.option(ChannelOption.TCP_NODELAY, true); 
		bootstrap.group(eventLoopGroup);
		bootstrap.remoteAddress(host, port);
		bootstrap.handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch){
				ch.pipeline().addLast(new IdleStateHandler(0, 2, 0));
				ch.pipeline().addLast(new MessageEncoder());
				ch.pipeline().addLast(new MessageDecoder());
				ch.pipeline().addLast(handler);
			}
		});
		ChannelFuture future = bootstrap.connect(host, port).addListener(new ConnectionListener(this)).sync();
		if (future.isSuccess()) {
			NettyClientBootStrap.socketChannel = (SocketChannel) future.channel();
			System.out.println(Thread.currentThread().getId()+":"+Thread.currentThread().getName());
			logger.info("Connected To Server[" + host + ":" + port + "] Successfully.");
		}
	}

	public void reconnect() throws InterruptedException {
		ChannelFuture future = bootstrap.connect(host, port).addListener(new ConnectionListener(this)).sync();
		NettyClientBootStrap.socketChannel = (SocketChannel) future.channel();
		logger.info("Reconnected To Server[" + host + ":" + port + "] Successfully.");
	}

	public SocketChannel getSocketChannel() {
		return NettyClientBootStrap.socketChannel;
	}
}
