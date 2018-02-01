package com.rabbitMQ;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.web.socket.TextMessage;

import com.websocket.MyWebSocketHandler;
import com.websocket.SpringContextUtil;

public class Consumer implements MessageListener {

	@Resource
	private AmqpTemplate amqpTemplate;


	@Override
	public void onMessage(Message message) {
		MyWebSocketHandler mwsh = (MyWebSocketHandler) SpringContextUtil.applicationcontext
				.getBean("MyWebSocketHandler");
		for (int i = 0; i < mwsh.sessionList.size(); i++) {
			TextMessage tm = new TextMessage(message.getBody());
			System.out.println("Ïû·ÑÕß" + tm);
			try {
				mwsh.sessionList.get(i).sendMessage(tm);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
