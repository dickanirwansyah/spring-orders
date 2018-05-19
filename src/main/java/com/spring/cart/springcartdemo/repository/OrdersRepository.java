package com.spring.cart.springcartdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cart.springcartdemo.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, String>{

}
