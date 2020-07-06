package ecom.product.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecom.product.api.exception.InvalidProductException;
import ecom.product.api.model.Order;
import ecom.product.api.model.OrderedProduct;
import ecom.product.api.model.ProductOrderRequest;
import ecom.product.api.model.Product;
import ecom.product.api.model.User;
import ecom.product.api.service.impl.OrderServiceImpl;
import ecom.product.api.service.impl.ProductServiceImpl;
import ecom.product.api.service.impl.UserServiceImpl;

/**
 * 
 * @author dhekumar2
 *
 */
@RestController
@RequestMapping(path = "/users/{userId}/orders")
public class ProductOrderController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private ProductServiceImpl productService;

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping
	public ResponseEntity<?> createOrder(@PathVariable("userId") long userId,
			@RequestBody ProductOrderRequest itemOrderRequest) throws InvalidProductException {
		Optional<User> user = userService.findById(userId);

		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		List<OrderedProduct> orderedProducts = new ArrayList<>();

		for (Product prod : itemOrderRequest.getItems()) {
			Optional<Product> product = productService.findById(prod.getId());
			if (!product.isPresent()) {
				return ResponseEntity.badRequest().body("invalid productId: " + prod.getId());
			}
			orderedProducts.add(new OrderedProduct(product.get(), prod.getAmount()));
		}

		Order order = orderService.createOrder(user.get(), orderedProducts);
		return ResponseEntity.ok(order);

	}
}