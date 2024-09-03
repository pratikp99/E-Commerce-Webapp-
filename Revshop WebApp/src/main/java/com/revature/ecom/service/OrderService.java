package com.revature.ecom.service;

import java.util.List;

import com.revature.ecom.Models.orderModel;

public interface OrderService {
	List<orderModel> getAllOrdersByUserId(int userId);
}
