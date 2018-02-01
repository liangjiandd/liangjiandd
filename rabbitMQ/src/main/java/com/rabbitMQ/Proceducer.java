package com.rabbitMQ;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Proceducer")
public class Proceducer {

	@Resource
	private AmqpTemplate amqpTemplate;

	public void sendMessage(Object message) {
		System.out.println("ЩњВњеп" + message);
		amqpTemplate.convertSendAndReceive("info", message);
	}
}
