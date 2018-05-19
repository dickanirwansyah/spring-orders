package com.spring.cart.springcartdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.cart.springcartdemo.entity.Orders;
import com.spring.cart.springcartdemo.entity.OrdersItem;
import com.spring.cart.springcartdemo.repository.OrdersItemRepository;
import com.spring.cart.springcartdemo.repository.OrdersRepository;

@Service
@Transactional
@Repository
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private OrdersItemRepository ordersItemRepository;

	@Override
	public Orders createdOrders(Orders orders) {
		ordersRepository.save(orders);
		List<OrdersItem> ordersItems = orders.getOrdersItems();
		for(OrdersItem itemsOrders : ordersItems) {
			OrdersItem item = new OrdersItem();
			item.setProductName(itemsOrders.getProductName());
			item.setPrice(itemsOrders.getPrice());
			item.setQuantity(itemsOrders.getQuantity());
			ordersItemRepository.save(item);
		}
		return orders;
	}

	@Override
	public List<Orders> listOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders findById(String idorders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Orders> findByIdIn(String idorders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders newOrders(Orders orders) {
		return ordersRepository.save(orders);
	}

}
