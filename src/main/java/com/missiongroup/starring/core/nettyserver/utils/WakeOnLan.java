package com.missiongroup.starring.core.nettyserver.utils;

import java.io.ByteArrayOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author MIT 网卡唤醒包
 */
public class WakeOnLan {
	private static final Logger logger = Logger.getLogger(WakeOnLan.class);

	private Pattern pattern;
	private int port;
	private DatagramSocket ds;

	public WakeOnLan() {
		this.pattern = Pattern.compile("^[0-9a-fA-F]{2}(\\:|\\-)[0-9a-fA-F]{2}(\\:|\\-)[0-9a-fA-F]{2}(\\:|\\-)[0-9a-fA-F]{2}(\\:|\\-)[0-9a-fA-F]{2}(\\:|\\-)[0-9a-fA-F]{2}$");
		this.port = 2034;
	}

	public void wakeUp(String mac) {
		wakeUp(mac, null);
	}

	public boolean initialize() {
		try {
			if (this.ds == null) {
				this.ds = new DatagramSocket();
				this.ds.setBroadcast(true);
			}
		} catch (SocketException e) {
			e.printStackTrace();
			logger.error(e);
			return false;
		}
		return true;
	}

	public void destroy() {
		if (this.ds != null) {
			this.ds.close();
		}
		this.ds = null;
	}

	public void wakeUp(String mac, String ip) {
		if (!this.pattern.matcher(mac).matches()) {
			return;
		}
		InetAddress destHost = null;
		try {
			destHost = InetAddress.getByName(ip);

			byte[] macBytes = getMacBytes(mac);
			ByteArrayOutputStream bw = new ByteArrayOutputStream();
			bw.write(new byte[] { -1, -1, -1, -1, -1, -1 });

			for (int i = 0; i < 16; i++) {
				bw.write(macBytes);
			}
			byte[] ps = bw.toByteArray();
			this.ds.send(new DatagramPacket(ps, ps.length, destHost, this.port));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	private byte[] getMacBytes(String mac) {
		String[] hex = mac.split("(\\:|\\-)");
		byte[] bytes = new byte[6];
		for (int i = 0; i < 6; i++) {
			bytes[i] = (byte) Integer.parseInt(hex[i], 16);
		}
		return bytes;
	}
}