package com.yewei.model.interceptor.aop.log;

import javax.persistence.Column;

public class LogSaveBean {
    private String project;

    private String host;
    
    private String method;
    
    private String argsStore;
    
    private String operationDetail;
    
    private long operationTime; //本次事务操作历时, 建议ms 作为单位

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getArgsStore() {
		return argsStore;
	}

	public void setArgsStore(String argsStore) {
		this.argsStore = argsStore;
	}

	public String getOperationDetail() {
		return operationDetail;
	}

	public void setOperationDetail(String operationDetail) {
		this.operationDetail = operationDetail;
	}

	public long getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(long operationTime) {
		this.operationTime = operationTime;
	}

	@Override
	public String toString() {
		return "LogSaveBean [project=" + project + ", host=" + host
				+ ", method=" + method + ", argsStore=" + argsStore
				+ ", operationDetail=" + operationDetail + ", operationTime="
				+ operationTime + "]";
	}
    
    
}
