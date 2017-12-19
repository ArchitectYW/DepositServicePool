package com.yewei.model.event;

import org.springframework.context.ApplicationEvent;

public class YeweiEvent extends ApplicationEvent{
	
	private EventType type;
	
	private String name;
	
	public YeweiEvent(EventType type,String name) {
		super(type);
		// TODO Auto-generated constructor stub
		this.type=type;
		this.name = name;
	}


	public EventType getType() {
		return type;
	}


	public void setType(EventType type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
