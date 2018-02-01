package com.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.rabbitMQ.Proceducer;
import com.rabbitmq.client.AMQP.Basic.Consume;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.sun.xml.internal.ws.resources.SenderMessages;

@Component("MyWebSocketHandler")
public class MyWebSocketHandler implements WebSocketHandler{
	
		public static final List<WebSocketSession> sessionList ;
		
		static{
			sessionList= new ArrayList<WebSocketSession>();
		}

		@Override
		public void afterConnectionClosed(WebSocketSession arg0, CloseStatus arg1) throws Exception {
			sessionList.remove(arg0);
		}

		@Override
		public void afterConnectionEstablished(WebSocketSession arg0) throws Exception {
					sessionList.add(arg0);
		}

		@Override
		public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1) throws Exception {
			Proceducer pro=(Proceducer)SpringContextUtil.applicationcontext.getBean("Proceducer");
			String mes= arg1.getPayload().toString();
			pro.sendMessage(mes);
			/*for(int i=0;i<sessionList.size();i++) {
				sessionList.get(i).sendMessage(arg1);
			}*/
		}

		@Override
		public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean supportsPartialMessages() {
			// TODO Auto-generated method stub
			return false;
		}
		
}
