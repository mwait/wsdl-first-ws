package com.wait.impl.client;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;

import com.wait.CustomerOrdersPortType;
import com.wait.CustomerOrdersService;
import com.wait.DeleteOrdersRequest;
import com.wait.DeleteOrdersResponse;
import com.wait.GetOrdersRequest;
import com.wait.GetOrdersResponse;
import com.wait.Order;
import com.wait.Product;

public class CustomerOrdersWSClient {

	public static void main(String[] args) {
		try {
			CustomerOrdersService service = new CustomerOrdersService (
					new URL("http://localhost:8080/wsdl-first-ws/services/customerOrders?wsdl"));
			
			CustomerOrdersPortType port = service.getCustomerOrdersPort();
			
			List<Order> orders =  get(port);
			
			System.out.println("================Order Details===============\n");
			
			for(Order order :orders) {
				List<Product> products = order.getProduct();
				for(Product product : products) {
					System.out.println("Product ID: "+product.getId());
					System.out.println("Product Description: "+product.getDescription());
					System.out.println("Product Quantity: "+product.getQuantity());
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	
	private static List<Order> get(CustomerOrdersPortType port) {
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		
		GetOrdersResponse response = port.getOrders(request);
		List<Order> orders = response.getOrder();
		return orders;
	}
	
	private static List<Order> delete(CustomerOrdersPortType port){
		DeleteOrdersRequest request = new DeleteOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		DeleteOrdersResponse response = port.deleteOrders(request);
		List<Order> orders = response.getOrder();
		return orders;
	}
	
	private static List<Order> create(CustomerOrdersPortType port) {
		//todo
		return null;
	}
}
