package com.yewei.adapter;

import com.yewei.model.deposit.ServiceEnum;

public interface DepositVendorAdapter {
 	public ServiceEnum getDepositVendorType();
    public void refund() throws Exception;
    public void deposit() throws Exception;
}
