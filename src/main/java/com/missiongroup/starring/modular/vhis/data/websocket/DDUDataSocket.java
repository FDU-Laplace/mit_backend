package com.missiongroup.starring.modular.vhis.data.websocket;

import com.alibaba.fastjson.JSON;
import com.missiongroup.starring.common.constant.cache.iCacheEnum;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.NotAssignRolesException;
import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.support.HttpKit;
import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.modular.system.controller.UserController;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.service.UserService;
import com.missiongroup.starring.modular.vhis.data.domain.TidData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

//{"lineId":"lid1","trainId":"tid1"}
@Component
@ServerEndpoint("/DataSocket/preparationScreen")
public class DDUDataSocket implements WebSocketServer {

	@Autowired
	private UserService userService;

	private ICache iCaches = SpringContextHolder.getBean(ICache.class);

	static Log log = LogFactory.getLog(DDUDataSocket.class);
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	private static List<String> onlineList = new CopyOnWriteArrayList<String>();
	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	private static CopyOnWriteArraySet<DDUDataSocket> webSocketSet = new CopyOnWriteArraySet<DDUDataSocket>();

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	//创建hashmap，用于存储线程
	public static ConcurrentHashMap<Session, OneThread> consoleThreadMap = new ConcurrentHashMap<Session, OneThread>();

	private String tid = "020";

	public static HashMap<String, Integer> ipCount = new HashMap<>();

	public String getTid() {
		return tid;
	}

	/**
	 * 连接建立成功调用的方法 tid 传递的参数 {"lineId":"lid1","trainId":"tid1"}
	 *
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("tid") String tid) {
		System.out.println("DDUDatasocket.onopen ------ 71");
		if (true) {
			//限制单ip页面数
			InetSocketAddress remoteAddress = WebsocketUtil.getRemoteAddress(session);
			String ip = remoteAddress.toString();
			int ipLength = ip.length();
			int count = 0;
			for(int i = ipLength - 1; i >= 0; i--){
				if(ip.charAt(i) != ':'){
					count++;
				}else{
					break;
				}
			}
			ip = ip.substring(1,ipLength - count);
			System.out.println("324332  " + ip);
			System.out.println("@@@@@@@@ipCount=" + ipCount);
			ipCount.put(ip, ipCount.getOrDefault(ip,0) + 1);
			if (ipCount.get(ip) > 100) {

				ShiroKit.getSubject().logout();
				throw new NotAssignRolesException(BizExceptionEnum.USER_NO_ROLE);
			}

			//实时推送数据给前端ddu
			this.session = session;
			webSocketSet.add(this); // 加入set中
			addOnlineCount(); // 在线数加1
			log.info("当前在线人数001为" + getOnlineCount());
			try {
				OneThread thread =null;
				thread=new OneThread(session);
				consoleThreadMap.put(this.session, thread);
				thread.start();
				sendMessage("连接成功001");
			} catch (IOException e) {
				log.error("websocket IO异常");
			}
		} else {
			log.error("IP校验失败，不存入缓存");
		}
		System.out.println("DDUDatasocket.onopen ------ 112");
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		System.out.println("DDUDatasocket.onclose ------ 120");
		InetSocketAddress remoteAddress = WebsocketUtil.getRemoteAddress(this.session);
		String ip = remoteAddress.toString();
		int ipLength = ip.length();
		int count = 0;
		for(int i = ipLength - 1; i >= 0; i--){
			if(ip.charAt(i) != ':'){
				count++;
			}else{
				break;
			}
		}
		ip = ip.substring(1,ipLength - count);
		ipCount.put(ip, ipCount.get(ip) - 1);
		consoleThreadMap.get(this.session).stop(); //关闭线程
		webSocketSet.remove(this); // 从set中删除
		subOnlineCount(); // 在线数减1
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("DDUDatasocket.onmessage ------ 146");
		consoleThreadMap.get(this.session).tid = message;
		tid = message;
		log.info("收到来自窗口的信息:" + message);
		// 群发消息
		for (DDUDataSocket item : webSocketSet) {
			try {
				item.sendMessage(message);
				System.out.println("客户端发送过来的消息"+message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("DDUDatasocket ------ 168");
		log.error("发生错误");
		error.printStackTrace();
	}

	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws IOException {
		System.out.println("DDUDatasocket.sendmessage ------ 177");
		try {
			System.out.println("实现服务器主动推送"+message);
			//this.session.getBasicRemote().sendText(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 群发自定义消息
	 */
	public static void sendInfo(String message) throws IOException {
		System.out.println("DDUDatasocket.sendinfo ------ 190");
		if (getOnlineCount() > 0) {
			for (DDUDataSocket item : webSocketSet) {
				try {
					item.sendMessage(message);
				} catch (IOException e) {
					continue;
				}
			}
		} else {
			log.info("没人链接不推送" + getOnlineCount());
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		DDUDataSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		DDUDataSocket.onlineCount--;
	}

	/**
	 * 链接接入 写入链接数据缓存
	 */
	public synchronized void addonlineList(String tid) {
		log.info("-----------增加缓存数据--------------S");
		// iCaches.put("常量名称""线路", "列车/车厢", );
		TidData tidData = JSON.parseObject(tid, TidData.class);
		// 写入缓存 缓存不存在写入 存在不处理
		iCaches.put(iCacheEnum.ICACHE_WEBSOCKET_TRAIN_DATA, tidData.getLineId() + tidData.getTrainId(), tid);
		// 再写入list 用于处理缓存删除判断
		DDUDataSocket.onlineList.add(tidData.getLineId() + tidData.getTrainId());
		System.out.println("21423423423");
		log.info("-----------增加缓存数据--------------E");
	}

	/**
	 * 链接断开 缓存数据删除
	 */
	public synchronized void subonlineList(String tid) {
		log.info("-----------删除缓存数据--------------S");
		TidData tidData = JSON.parseObject(tid, TidData.class);
		// 删除LIST中一个元素
		DDUDataSocket.onlineList.remove(tidData.getLineId() + tidData.getTrainId());
		// 检查LIST中是否还要元素
		if (onlineList.contains(tidData.getLineId() + tidData.getTrainId())) {
			log.info("数组中还存在连接元素,暂不删除缓存");
		} else {
			iCaches.remove(iCacheEnum.ICACHE_WEBSOCKET_TRAIN_DATA, tidData.getLineId() + tidData.getTrainId());
//			List<String> str = iCaches.getKeys(LINE);
//			for (int i = 0; i < str.size(); i++) {
//				System.out.println(str.get(i));
//			}
			log.info("删除缓存:" + tid);
		}
		log.info("-----------删除缓存数据--------------E");
	}

	private static Object getFieldInstance(Object obj, String fieldPath) {
		String fields[] = fieldPath.split("#");
		for (String field : fields) {
			obj = getField(obj, obj.getClass(), field);
			if (obj == null) {
				return null;
			}
		}

		return obj;
	}

	private static Object getField(Object obj, Class<?> clazz, String fieldName) {
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				Field field;
				field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field.get(obj);
			} catch (Exception e) {
			}
		}

		return null;
	}
}
