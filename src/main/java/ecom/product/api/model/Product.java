package ecom.product.api.model;

import ecom.product.api.entity.RootEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product extends RootEntity {
	
	private long productId;
    private String name;
    private String description;
    private double amount;
}
