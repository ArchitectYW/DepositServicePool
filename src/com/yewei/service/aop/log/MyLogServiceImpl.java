package com.yewei.service.aop.log;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yewei.model.interceptor.aop.log.AutoLog;

@Component
@Service("myLogService")
public class MyLogServiceImpl implements MyLogService{

	@Override
	@AutoLog(value = "�û�:${arg0} ����������ӿ�")
	public void log1(String name ) {
		// TODO Auto-generated method stub
		System.out.println("log1 in !!!");
	}

	@Override
	@AutoLog(value = "�û�:${arg0} ����������ӿ�,����Ҫ��������飺${arg1}")
	public void log2(String name,String action ) {
		// TODO Auto-generated method stub

		System.out.println("log2 in !!!");
	}
}
