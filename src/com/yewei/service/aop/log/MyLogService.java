package com.yewei.service.aop.log;

import com.yewei.model.interceptor.aop.log.AutoLog;

public interface MyLogService {
	@AutoLog(value = "�û�:${arg0} ����������ӿ�")
	public void log1(String name );

	@AutoLog(value = "�û�:${arg0} ����������ӿ�,����Ҫ��������飺${arg1}")
	public void log2(String name,String action);
}
