package com.yewei.service.aop.log;

import com.yewei.model.interceptor.aop.log.AutoLog;

public interface MyLogService {
	@AutoLog(value = "用户:${arg0} 调用了这个接口")
	public void log1(String name );

	@AutoLog(value = "用户:${arg0} 调用了这个接口,他想要做这件事情：${arg1}")
	public void log2(String name,String action);
}
