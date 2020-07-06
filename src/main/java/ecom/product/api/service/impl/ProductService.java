package ecom.product.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ecom.product.api.model.Product;

@Service
public interface ProductService {

	public void deleteById(Long id);
	public Product save(Product product);
	public Optional<Product> findById(long id);
	public List<Product> findAll();
}
