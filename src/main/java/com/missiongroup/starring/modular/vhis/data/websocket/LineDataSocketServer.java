package com.missiongroup.starring.modular.vhis.data.websocket;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.missiongroup.starring.common.constant.cache.iCacheEnum;
import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.modular.vhis.data.domain.TidData;

import javax.websocket.*;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

//{"lineId":"lid1","trainId":"tid1"}
@Component
@ServerEndpoint("/lineDataSocketServer/{lid}")
public class LineDataSocketServer implements WebSocketServer {

	private ICache iCaches = SpringContextHolder.getBean(ICache.class);

	static Log log = LogFactory.getLog(LineDataSocketServer.class);
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	private static List<String> onlineList = new CopyOnWriteArrayList<String>();
	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	private static CopyOnWriteArraySet<LineDataSocketServer> webSocketSet = new CopyOnWriteArraySet<LineDataSocketServer>();

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	// 接收sid
	private String lid = "";

	/**
	 * 连接建立成功调用的方法 lid 传递的参数 {"lineId":"lid1"}。
	 *
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("lid") String lid) {
		// IP检查
		Async async = session.getAsyncRemote();
		InetSocketAddress addr = (InetSocketAddress) getFieldInstance(async,
				"base#socketWrapper#socket#sc#remoteAddress");
		if (true) {
			this.session = session;
			webSocketSet.add(this); // 加入set中
			addOnlineCount(); // 在线数加1
			this.lid = lid;
			log.info("有新窗口开始监听:" + lid + ",当前在线人数为" + getOnlineCount());
			addonlineList(lid);// 写入缓存
			try {
				sendMessage("连接成功");
			} catch (IOException e) {
				log.error("websocket IO异常");
			}
		} else {
			log.error("IP校验失败，不存入缓存");
		}
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		// System.out.println(this.lid);
		if (this.lid.equals("")) {
			log.info("有一连接关闭！没有缓存删除，当前在线人数为" + getOnlineCount());
			webSocketSet.remove(this); // 从set中删除
		} else {
			webSocketSet.remove(this); // 从set中删除
			subOnlineCount(); // 在线数减1
			log.info("有一连接关闭！删除缓存" + this.lid + "当前在线人数为" + getOnlineCount());
			subonlineList(this.lid); // 删除缓存
		}
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		log.info("收到来自窗口" + lid + "的信息:" + message);
		// 群发消息
		for (LineDataSocketServer item : webSocketSet) {
			try {
				item.sendMessage(message);
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
		if (lid == null) {

		}
		log.error("发生错误");
		error.printStackTrace();
	}

	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws IOException {
		try {
			this.session.getBasicRemote().sendText(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 群发自定义消息
	 */
	public static void sendInfo(String message, String lid) throws IOException {

		if (getOnlineCount() > 0) {
			log.info("推送消息到窗口" + lid + "，推送内容:" + message);
			for (LineDataSocketServer item : webSocketSet) {
				try {
					// 这里可以设定只推送给这个tid的，为null则补处理
					if (lid == null) {
						// item.sendMessage(message);
					} else if (item.lid.equals(lid)) {
						item.sendMessage(message);
					}
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
		LineDataSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		LineDataSocketServer.onlineCount--;
	}

	/**
	 * 链接接入 写入链接数据缓存
	 */
	public synchronized void addonlineList(String lid) {
		log.info("-----------增加缓存数据--------------S");
		// iCaches.put("常量名称""线路", "列车/车厢", );
		TidData tidData = JSON.parseObject(lid, TidData.class);
		// 写入缓存 缓存不存在写入 存在不处理
		iCaches.put(iCacheEnum.ICACHE_WEBSOCKET_LINE_DATA, tidData.getLineId(), lid);
		// 再写入list 用于处理缓存删除判断
		LineDataSocketServer.onlineList.add(tidData.getLineId());
		log.info("-----------增加缓存数据--------------E");
	}

	/**
	 * 链接断开 缓存数据删除
	 */
	public synchronized void subonlineList(String lid) {
		log.info("-----------删除缓存数据--------------S");
		TidData tidData = JSON.parseObject(lid, TidData.class);
		// 删除LIST中一个元素
		LineDataSocketServer.onlineList.remove(tidData.getLineId());
		// 检查LIST中是否还要元素
		if (onlineList.contains(tidData.getLineId() )) {
			log.info("数组中还存在连接元素,暂不删除缓存");
		} else {
			iCaches.remove(iCacheEnum.ICACHE_WEBSOCKET_LINE_DATA, tidData.getLineId() );
//			List<String> str = iCaches.getKeys(LINE);
//			for (int i = 0; i < str.size(); i++) {
//				System.out.println(str.get(i));
//			}
			log.info("删除缓存:" + lid);
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
