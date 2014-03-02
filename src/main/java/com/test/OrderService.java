package com.test;

import com.test.vo.OrderVO;

public interface OrderService {
	
	Double test(String compName);
	OrderVO getOrder(String orderId);

}
