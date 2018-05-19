package com.spring.cart.springcartdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tabel_orders")
@Entity
public class Orders {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String idorders;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Email
	@Column(name="customer_email", nullable=false)
	private String customerEmail;
	
	@Column(name="customer_address", nullable=false)
	private String customerAddress;
	
	@Column(name="customer_phone", nullable=false)
	private String customerPhone;
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<OrdersItem> ordersItems = new ArrayList<>();
}
