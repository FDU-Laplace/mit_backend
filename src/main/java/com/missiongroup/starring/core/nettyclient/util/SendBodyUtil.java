//package com.missiongroup.starring.core.nettyclient.util;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//
//import com.missiongroup.starring.core.util.ToolUtil;
//import com.missiongroup.starring.modular.vhis.device.domain.Device;
//
//@SuppressWarnings("all")
//public class SendBodyUtil {
//
//	/**
//	 * 创建截图命令调用的 body
//	 * 
//	 * @param url
//	 * @return string
//	 * @throws Exception
//	 */
//	public static String captureBody(String url) throws Exception {
//		Document doc = DocumentHelper.createDocument();
//		doc.setXMLEncoding("UTF-8");
//		Element root = doc.addElement("msg");
//		Element filePath = root.addElement("FilePath");
//		filePath.addText(url);
//		return doc.asXML();
//	}
//
//	/**
//	 * 创建设置音量调用的 body
//	 * 
//	 * @param url
//	 * @return
//	 * @throws Exception
//	 */
//	public static String volumeBody(String volume) throws Exception {
//		Document doc = DocumentHelper.createDocument();
//		doc.setXMLEncoding("UTF-8");
//		Element root = doc.addElement("msg");
//		Element vol = root.addElement("data");
//		vol.addText(volume);
//		return doc.asXML();
//	}
//
//	/** 生成PDU控制LED和LCD的开关屏报文体
//	 * @param devices
//	 * @param upDevices
//	 * @return
//	 */
//	public static String onoffLedLcdPduBody(List<Device> devices, List<Device> upDevices) {
//		Document doc = DocumentHelper.createDocument();
//		try {
//			Element msg = doc.addElement("msg");
//			HashMap<String, String> upDevStoreMap = new HashMap<String, String>();
//			if (ToolUtil.isNotEmpty(upDevices)) {
//				for (Device upDevice : upDevices) {
//					upDevStoreMap.put(upDevice.getUuid(), upDevice.getIp());
//				}
//			}
//			if (ToolUtil.isNotEmpty(devices)) {
//				for (Device device : devices) {
//					Element data = msg.addElement("data");
//					Element upIp = data.addElement("upIp");
//					upIp.setText(upDevStoreMap.get(device.getParentId()));
//					Element pdu_ip = data.addElement("pdu_ip");
//					pdu_ip.setText((device.getPduIp() == null ? "" : device.getPduIp()));
//					Element pdu_port_num = data.addElement("pdu_port_num");
//					pdu_port_num.setText((device.getPduPort() == null ? "" : device.getPduPort().toString()));
//					Element com = data.addElement("com");
//					if (device.getCom() != null) {
//						com.setText(device.getCom().toString());
//					}
//					Element screenNo = data.addElement("screenNo");
//					screenNo.setText((device.getScreenNo() == null ? "" : device.getScreenNo()));
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return doc.asXML();
//	}
//
//	/** 生成PDU控制LED和LCD的定时开关屏报文体
//	 * @param devices
//	 * @param upDevices
//	 * @param openTime
//	 * @param closeTime
//	 * @return
//	 */
//	public static String timingSwitchScreenBody(List<Device> devices, List<Device> upDevices, String openTime, String closeTime) {
//		Document doc = DocumentHelper.createDocument();
//		try {
//			Element msg = doc.addElement("msg");
//			Element el = msg.addElement("cancel");
//			el.setText("false");
//			HashMap<String, String> upDevStoreMap = new HashMap<String, String>();
//			if (ToolUtil.isNotEmpty(upDevices)) {
//				for (Device upDevice : upDevices) {
//					upDevStoreMap.put(upDevice.getUuid(), upDevice.getIp());
//				}
//			}
//			/**
//			 * <?xml version="1.0" encoding="UTF-8"?> <msg> <data>
//			 * <pdu_ip>10.2.128.110</pdu_ip> <pdu_port_num>2</pdu_port_num>
//			 * <open_time>00:00</open_time> <close_time>23:59</close_time> </data> <data>
//			 * <pdu_ip>192.168.1.125</pdu_ip> <pdu_port_num>80</pdu_port_num>
//			 * <open_time>00:00</open_time> <close_time>23:59</close_time> </data> </msg>
//			 */
//			if (ToolUtil.isNotEmpty(devices)) {
//				for (Device device : devices) {
//					Element data = msg.addElement("data");
//					Element cancel = data.addElement("cancel");
//					cancel.setText("false");
//					Element upIp = data.addElement("upIp");
//					upIp.setText(upDevStoreMap.get(device.getParentId()));
//					Element pdu_ip = data.addElement("pdu_ip");
//					pdu_ip.setText((device.getPduIp() == null ? "" : device.getPduIp()));
//					Element pdu_port_num = data.addElement("pdu_port_num");
//					pdu_port_num.setText((device.getPduPort() == null ? "" : device.getPduPort().toString()));
//					Element com = data.addElement("com");
//					if (device.getCom() != null) {
//						com.setText(device.getCom().toString());
//					}
//					Element open_time = data.addElement("open_time");
//					open_time.setText(openTime);
//					Element close_time = data.addElement("close_time");
//					close_time.setText(closeTime);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return doc.asXML();
//	}
//
//	/*
//	 * 生成取消定时开关屏报文体
//	 */
//	public static String cancelTimingSwitchScreenBody(List<Device> devices, List<Device> upDevices) {
//		Document doc = DocumentHelper.createDocument();
//		try {
//			Element msg = doc.addElement("msg");
//			Element el = msg.addElement("cancel");
//			el.setText("true");
//			HashMap<String, String> upDevStoreMap = new HashMap<String, String>();
//			if (ToolUtil.isNotEmpty(upDevices)) {
//				for (Device upDevice : upDevices) {
//					upDevStoreMap.put(upDevice.getUuid(), upDevice.getIp());
//				}
//			}
//			/**
//			 * <?xml version="1.0" encoding="UTF-8"?> <msg> <data>
//			 * <pdu_ip>10.2.128.110</pdu_ip> <pdu_port_num>2</pdu_port_num> </data> <data>
//			 * <pdu_ip>192.168.1.125</pdu_ip> <pdu_port_num>80</pdu_port_num> </data> </msg>
//			 */
//			if (ToolUtil.isNotEmpty(devices)) {
//				for (Device device : devices) {
//					Element data = msg.addElement("data");
//					Element cancel = data.addElement("cancel");
//					cancel.setText("true");
//					Element upIp = data.addElement("upIp");
//					upIp.setText(upDevStoreMap.get(device.getParentId()));
//					Element pdu_ip = data.addElement("pdu_ip");
//					pdu_ip.setText((device.getPduIp() == null ? "" : device.getPduIp()));
//					Element pdu_port_num = data.addElement("pdu_port_num");
//					pdu_port_num.setText((device.getPduPort() == null ? "" : device.getPduPort().toString()));
//					Element com = data.addElement("com");
//					if (device.getCom() != null) {
//						com.setText(device.getCom().toString());
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return doc.asXML();
//	}
//
//	/** PC设置定时开关机
//	 * @param devices
//	 * @param openTime
//	 * @param closeTime
//	 * @return
//	 */
//	public static String timingBootBody(List<Device> devices, String openTime, String closeTime) {
//		Document doc = DocumentHelper.createDocument();
//		try {
//			Element msg = doc.addElement("msg");
//			Element el = msg.addElement("cancel");
//			el.setText("false");
//			/**
//			 * <?xml version="1.0" encoding="UTF-8"?>
//			 * <msg><cancel>false</cancel><data><cancel>false</cancel><ip>192.168.0.130</ip><port_num>8182</port_num><open_time>undefined</open_time><close_time>23:59</close_time></data></msg>
//			 */
//			if (ToolUtil.isNotEmpty(devices)) {
//				for (Device device : devices) {
//					Element data = msg.addElement("data");
//					Element cancel = data.addElement("cancel");
//					cancel.setText("false");
//					Element ip = data.addElement("ip");
//					ip.setText((device.getIp() == null ? "" : device.getIp()));
//					Element port_num = data.addElement("port_num");
//					port_num.setText((device.getPort() == null ? "" : device.getPort()));
//					Element open_time = data.addElement("open_time");
//					open_time.setText(openTime);
//					Element close_time = data.addElement("close_time");
//					close_time.setText(closeTime);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return doc.asXML();
//	}
//	
//	/** PC取消定时开关机
//	 * @param devices
//	 * @return
//	 */
//	public static String cancelTimingBootBody(List<Device> devices) {
//		Document doc = DocumentHelper.createDocument();
//		try {
//			Element msg = doc.addElement("msg");
//			Element el = msg.addElement("cancel");
//			el.setText("true");
//			/**
//			 * <?xml version="1.0" encoding="UTF-8"?>
//			 * <msg><cancel>false</cancel><data><cancel>false</cancel><ip>192.168.0.130</ip><port_num>8182</port_num></data></msg>
//			 */
//			if (ToolUtil.isNotEmpty(devices)) {
//				for (Device device : devices) {
//					Element data = msg.addElement("data");
//					Element cancel = data.addElement("cancel");
//					cancel.setText("true");
//					Element ip = data.addElement("ip");
//					ip.setText((device.getIp() == null ? "" : device.getIp()));
//					Element port_num = data.addElement("port_num");
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return doc.asXML();
//	}
//
//	public static String scheduleBody(List<Map<String, String>> maps) {
//		Document doc = DocumentHelper.createDocument();
//		try {
//			Element msg = doc.addElement("msg");
//			if (ToolUtil.isNotEmpty(maps)) {
//				for (Map<String, String> map : maps) {
//					Element data = msg.addElement("data");
//					Element ip = data.addElement("ip");
//					ip.setText(map.get("ip"));
//					Element port_num = data.addElement("port_num");
//					port_num.setText(map.get("port"));
//					Element open_time = data.addElement("open_time");
//					open_time.setText(map.get("openTime"));
//					Element close_time = data.addElement("close_time");
//					close_time.setText(map.get("closeTime"));
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return doc.asXML();
//	}
//}
