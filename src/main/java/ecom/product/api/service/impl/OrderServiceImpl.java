package ecom.product.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecom.product.api.constants.Status;
import ecom.product.api.model.Order;
import ecom.product.api.model.OrderedProduct;
import ecom.product.api.model.User;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private Order order;
	
	public Order createOrder(User user, List<OrderedProduct> orderedProducts) {
		//order = new Order();
		order.setOrderedProducts(orderedProducts);
		order.setUser(user);
		order.setStatus(Status.OPEN);
		return order;
	}

}
