package com.spring.cart.springcartdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cart.springcartdemo.entity.OrdersItem;

public interface OrdersItemRepository extends JpaRepository<OrdersItem, Long>{
	
	OrdersItem findById(String id);
	Optional<OrdersItem> findByIdIn(String id);
}
