package com.missiongroup.starring.core.nettyclient;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.missiongroup.starring.core.nettyclient.entity.IOMessage;
import com.missiongroup.starring.core.nettyclient.thread.GuardListenerThread;
//import com.missiongroup.starring.modular.vhis.device.domain.Device;
//import com.missiongroup.starring.modular.vhis.device.repository.DeviceRespository;

import io.netty.channel.socket.SocketChannel;

//@Component
public class ClientNetService implements InitializingBean, ServletContextAware {

	private static final Logger logger = LoggerFactory.getLogger(ClientNetService.class);

	private String host = "127.0.0.0";

	private String port = "8182";

	public static GuardListenerThread guardListenerThread;

	public static CountDownLatch latch = null;

	public static IOMessage receiveMessage = null;
	
//	@Autowired
//	private DeviceRespository deviceRespository;

	public static IOMessage send(IOMessage ioMessage) {
		try {
			ClientNetService.latch = new CountDownLatch(1);
			if (ClientNetService.getActiveChannel() == null || !ClientNetService.getActiveChannel().isActive()) {
				return null;
			}
			ClientNetService.getActiveChannel().writeAndFlush(ioMessage);
			ClientNetService.latch.await();
			return ClientNetService.receiveMessage;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

//	@Override
//	public void setServletContext(ServletContext servletContext) {
//		try {
//			List<Device> devices = deviceRespository.findByParentId("0");
//			if (devices != null && devices.size() == 1) {
//				Device device = devices.get(0);
//				this.host = device.getIp();
//				this.port = device.getPort();
//				ClientNetService.guardListenerThread = new GuardListenerThread(host, Integer.valueOf(port));
//				ClientNetService.guardListenerThread.run();
//			}
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	public static SocketChannel getActiveChannel() {
		return NettyClientBootStrap.socketChannel;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		
	}
}
