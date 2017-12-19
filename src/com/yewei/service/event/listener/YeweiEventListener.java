package com.yewei.service.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.yewei.model.event.YeweiEvent;
@Service("yeweiEventListener")
public class YeweiEventListener implements ApplicationListener<YeweiEvent> {

	@Override
	public void onApplicationEvent(YeweiEvent event) {
		// TODO Auto-generated method stub
		System.out.println("���յ��¼���"+event.getType().toString());
		switch(event.getType()){
		case on_order_create:
			System.out.println("���������ˣ���Ҫ��ʲô");
			break;
		case user_register:
			System.out.println("�û�"+event.getName()+"ע���ˣ���Ҫ��ʲô");
			break;
		}
	}

}
