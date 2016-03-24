package com.wait.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wait.CreateOrdersRequest;
import com.wait.CreateOrdersResponse;
import com.wait.CustomerOrdersPortType;
import com.wait.DeleteOrdersRequest;
import com.wait.DeleteOrdersResponse;
import com.wait.GetOrdersRequest;
import com.wait.GetOrdersResponse;
import com.wait.Order;
import com.wait.Product;

public class CustomersOrdersWSImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	int currentCustomerId;
	public CustomersOrdersWSImpl() {
		init();
	}
	
	public void init() {
		List<Order> orders = new ArrayList<Order>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		Product product = new Product();
		product.setDescription("IPhone");
		product.setId("1");
		product.setQuantity(BigInteger.valueOf(3));
		
		order.getProduct().add(product);
		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentCustomerId), orders);
	}
	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		GetOrdersResponse response = new GetOrdersResponse();
		List<Order> responseOrders = response.getOrder();
		for(Order order:orders) {
			responseOrders.add(order);
		}
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		Order order = request.getOrder();
		if (customerOrders.containsKey(request.getCustomerId())) {
			List<Order> currentOrders = customerOrders.get(request.getCustomerId());
			currentOrders.add(order);
		} else {
			List<Order> newOrders = new ArrayList<>();
			newOrders.add(order);
			customerOrders.put(BigInteger.valueOf(++currentCustomerId), newOrders);
		}
		
		CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();
		createOrdersResponse.setResult(true);

		return createOrdersResponse;
	}

	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		
		DeleteOrdersResponse response = new DeleteOrdersResponse();
		List<Order> responseOrders = response.getOrder();
		for(Order order:orders) {
			responseOrders.add(order);
		}
		customerOrders.remove(customerId);
		return response;
	}

}
