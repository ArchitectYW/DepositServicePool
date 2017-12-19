package com.yewei.service.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

import com.yewei.model.event.EventType;
import com.yewei.model.event.YeweiEvent;

@Service("eventService")
public class EventServiceImpl implements EventService,ApplicationContextAware {

	@Override
	public String userRegister(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"注册了！");
		
		//发布事件
		applicationContext.publishEvent(new YeweiEvent(EventType.user_register,name));
		return "SUCCESS";
	}

    private ApplicationContext applicationContext;
       
	
	@Override
	public void setApplicationContext(ApplicationContext ctx){
		 this.applicationContext = ctx;
	}

}
