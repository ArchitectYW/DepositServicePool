package com.yewei.service.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.yewei.model.event.YeweiEvent;
@Service("yeweiEventListener")
public class YeweiEventListener implements ApplicationListener<YeweiEvent> {

	@Override
	public void onApplicationEvent(YeweiEvent event) {
		// TODO Auto-generated method stub
		System.out.println("接收到事件："+event.getType().toString());
		switch(event.getType()){
		case on_order_create:
			System.out.println("订单创建了，你要做什么");
			break;
		case user_register:
			System.out.println("用户"+event.getName()+"注册了，你要做什么");
			break;
		}
	}

}
