package ecom.product.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecom.product.api.constants.Status;
import ecom.product.api.model.Order;
import ecom.product.api.model.OrderedProduct;
import ecom.product.api.model.Product;
import ecom.product.api.model.User;
import ecom.product.api.service.OrderService;
import ecom.product.api.util.ProductUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	private List<Product> productList = new ArrayList<>();
	
	private Order order;
	
	public Order createOrder(User user, List<OrderedProduct> orderedProducts) {
		order = new Order();
		order.setOrderedProducts(orderedProducts);
		order.setUser(user);
		order.setStatus(Status.OPEN);
		return order;
	}

}
