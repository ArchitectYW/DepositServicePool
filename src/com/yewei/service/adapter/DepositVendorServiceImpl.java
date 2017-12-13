package com.yewei.service.adapter;

import org.springframework.stereotype.Service;

import com.yewei.adapter.DepositVendorAdapter;
import com.yewei.core.YeweiServicePoolBase;

@Service("depositVendorService")
public class DepositVendorServiceImpl extends YeweiServicePoolBase<DepositVendorAdapter> implements DepositVendorService {
	
	public DepositVendorServiceImpl() {
	}

	@Override
	public String getServiceBeanName(DepositVendorAdapter theServiceBean) {
		// TODO Auto-generated method stub
		return theServiceBean.getDepositVendorType().name();
	}
	
	

	@Override
	public void deposit(String str) throws Exception {
		// TODO Auto-generated method stub
		DepositVendorAdapter vendorAdapter = this.servicePool.get(str);
        if (vendorAdapter == null) {
            throw new Exception("Vendor Not Defined");
        }
        vendorAdapter.deposit();
	}

	@Override
	public void refund() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
