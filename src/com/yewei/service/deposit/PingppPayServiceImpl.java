package com.yewei.service.deposit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yewei.adapter.DepositVendorAdapter;
import com.yewei.model.deposit.ServiceEnum;

@Service("pingppPayService")
public class PingppPayServiceImpl implements  DepositVendorAdapter {
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deposit() throws Exception {
		System.out.println("pingpp pay");
	}

	@Override
	public ServiceEnum getDepositVendorType() {
		// TODO Auto-generated method stub
		return ServiceEnum.pingpp;
	}

	@Override
	public void refund() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
