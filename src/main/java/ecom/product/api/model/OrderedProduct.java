package ecom.product.api.model;

import java.util.List;

import ecom.product.api.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderedProduct { //extends RootEntity {

	private List<Product> productList;
	private Order order;
	private double totalPrice;
	private Product product;
	private double amount;
	public OrderedProduct(Product product, double amount) { 
		this.product = product; 
		this.amount = amount; 
		}
	 
}
