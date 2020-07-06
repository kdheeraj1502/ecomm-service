package ecom.product.api.service.impl;

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

	@Autowired
	List<Product> products;

	@Autowired
	Product product;
	
	@PostConstruct
	private void postConstruct() {
		product.setAmount(35);
		product.setName("Pepsi");
		product.setProductId(789l);
		product.setDescription("cold drink");
		products.add(product);
		addProducts(product);
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
