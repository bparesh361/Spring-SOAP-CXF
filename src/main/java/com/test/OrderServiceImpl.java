package com.test;

import javax.jws.WebService;

import com.test.vo.OrderVO;

//@WebService
public class OrderServiceImpl implements OrderService{

	public Double test(String compName) {
		return new Double("10.20");
	}

	public OrderVO getOrder(String orderId) {
		OrderVO vo = new OrderVO();
		vo.setOrderId(orderId);
		vo.setOrderStatus("completed");
		return vo;
	}
	
		
}
