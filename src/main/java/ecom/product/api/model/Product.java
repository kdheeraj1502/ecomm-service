package ecom.product.api.model;

import org.springframework.stereotype.Component;

import ecom.product.api.entity.RootEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Product extends RootEntity {
	
	private long productId;
    private String name;
    private String description;
    private double amount;
}
