package com.missiongroup.starring.modular.vhis.data.websocket;

import java.io.IOException;

import javax.websocket.Session;



public interface WebSocketServer {

	void onOpen(Session session,String sid);
	
	void onClose();
	
	void onMessage(String message, Session session);
	
	void onError(Session session, Throwable error);
	
	void sendMessage(String message) throws IOException;
}
