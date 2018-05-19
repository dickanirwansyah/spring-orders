package com.spring.cart.springcartdemo.service;

import java.util.List;
import java.util.Optional;

import com.spring.cart.springcartdemo.entity.Orders;

public interface OrdersService {
	
	Orders createdOrders(Orders orders);
	List<Orders> listOrders();
	Orders findById(String idorders);
	Optional<Orders> findByIdIn(String idorders);
}
