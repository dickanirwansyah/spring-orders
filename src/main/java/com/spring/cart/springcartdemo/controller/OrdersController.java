package com.spring.cart.springcartdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cart.springcartdemo.entity.Orders;
import com.spring.cart.springcartdemo.repository.OrdersRepository;
import com.spring.cart.springcartdemo.service.OrdersService;

@RestController
@RequestMapping(value = "/api/carts")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@PostMapping(value="/create")
	public ResponseEntity<Orders> create(@RequestBody Orders orders){
		return Optional.ofNullable(ordersService.createdOrders(orders))
				.map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
				.orElse(new ResponseEntity<Orders>(HttpStatus.BAD_REQUEST));
	}
	
	@PostMapping(value="/created")
	public ResponseEntity<Orders> created(@RequestBody Orders orders){
		return Optional.ofNullable(ordersRepository.save(orders))
				.map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
				.orElse(new ResponseEntity<Orders>(HttpStatus.BAD_REQUEST));
	}
	
	@GetMapping("")
	public ResponseEntity<List<Orders>> listOrders(){
		return Optional.ofNullable(ordersRepository.findAll())
				.map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
				.orElse(new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping(value="/{idorders}")
	public Optional<Orders> findByIdorders(@PathVariable String idorders){
		//return ordersRepository.findById(idorders);
		return null;
	}
}
