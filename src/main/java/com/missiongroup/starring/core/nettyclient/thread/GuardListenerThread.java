package com.missiongroup.starring.core.nettyclient.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardListenerThread implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(GuardListenerThread.class);

	private ConnectListenerThread connectListenerThread;

	private String host;

	private int port;
	
	public GuardListenerThread() {
		
	}
	
	public GuardListenerThread(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			this.connectListenerThread = new ConnectListenerThread(this.host, this.port);
			connectListenerThread.run();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public ConnectListenerThread getConnectListenerThread() {
		return connectListenerThread;
	}

}
