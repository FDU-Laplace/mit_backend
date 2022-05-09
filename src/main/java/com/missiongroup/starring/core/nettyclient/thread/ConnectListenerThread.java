package com.missiongroup.starring.core.nettyclient.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.missiongroup.starring.core.nettyclient.NettyClientBootStrap;

public class ConnectListenerThread implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(ConnectListenerThread.class);
	/**
	 * 连接状态
	 */
	private boolean isConnected = true;
	/**
	 * 连接启动项
	 */
	private NettyClientBootStrap bootstrap;

	private String host;

	private int port;

	public ConnectListenerThread() {

	}

	public ConnectListenerThread(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			logger.info("Connect To Server...");
			this.bootstrap = new NettyClientBootStrap(host, port);
		} catch (Exception e) {
			this.isConnected = false;
			logger.error(e.getMessage());
		}
	}
	
	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public NettyClientBootStrap getBootstrap() {
		return bootstrap;
	}

}
