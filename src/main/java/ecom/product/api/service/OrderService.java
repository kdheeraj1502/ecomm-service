package ecom.product.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ecom.product.api.model.Order;
import ecom.product.api.model.OrderedProduct;
import ecom.product.api.model.User;

@Service
public interface OrderService {

	public Order createOrder(User user, List<OrderedProduct> orderProducts);
	
}
