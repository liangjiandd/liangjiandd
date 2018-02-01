package com.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
@Component
public class MyWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
		
		@Autowired
		MyWebSocketHandler	handler;
		
		@Override
		public void registerWebSocketHandlers(WebSocketHandlerRegistry arg0) {
				arg0.addHandler(handler, "/ws").addInterceptors(new MyHandlerInterceptor());
		}
}
