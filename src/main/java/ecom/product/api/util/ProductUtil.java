package ecom.product.api.util;

import java.util.List;

import ecom.product.api.model.Product;

public class ProductUtil {
	
	public static double productPriceSum(List<Product> products) {
		return products.stream().map(p -> p.getAmount() ).mapToDouble(Double::valueOf).sum();
	}

}
