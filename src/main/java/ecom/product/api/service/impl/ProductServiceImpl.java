package ecom.product.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecom.product.api.model.Product;
import lombok.Data;

@Data
@Service
public class ProductServiceImpl {

	List<Product> products;

	@PostConstruct
	private void postConstruct() {
		products = new ArrayList<>();
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		product1.setAmount(35);
		product1.setName("Pepsi");
		product1.setProductId(789l);
		product1.setAmount(40);
		product1.setName("Cock");
		product1.setProductId(345l);
		product1.setAmount(100);
		product1.setName("Chips");
		product1.setProductId(589l);
		products.add(product1);
		products.add(product1);
		addProducts(product1);
		addProducts(product2);
		addProducts(product3);
	}

	private void addProducts(Product product) {
		products.add(product);
	}

	public Optional<Product> findById(long id) {

		return products.stream().filter(p -> {
			if (p.getProductId() == id) {
				return true;
			} else
				return false;
		}).findAny();
	}

	public Product save(Product product) {
		products.add(product);
		return product;
	}

	public Object findAll() {
		return products;
	}

	public void deleteById(long id) {
		products.stream().filter(p -> {
			if (p.getProductId() == id) {
				products.remove(p);
				return true;
			} else
				return false;
		}).count();

	}

}
