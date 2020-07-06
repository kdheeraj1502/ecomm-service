package ecom.product.api.model;

import ecom.product.api.entity.RootEntity;
import ecom.product.api.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockItem extends RootEntity {
	
    private Product product;
    private double amount;
}