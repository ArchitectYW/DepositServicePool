package com.yewei.service.deposit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yewei.adapter.DepositVendorAdapter;
import com.yewei.model.ServiceEnum;

@Service("unionPayService")
public class UnionPayServiceImpl implements  DepositVendorAdapter {
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deposit() throws Exception {
		System.out.println("unionpay pay");
	}

	@Override
	public ServiceEnum getDepositVendorType() {
		// TODO Auto-generated method stub
		return ServiceEnum.unionpay;
	}

	@Override
	public void refund() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
