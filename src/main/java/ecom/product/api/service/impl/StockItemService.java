package ecom.product.api.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ecom.product.api.model.StockItem;

@Service
public interface StockItemService {
	
    Optional<StockItem> findByProductId(long productId);

	public void deleteById(Long id);

	public Optional<StockItem> findById(long id);

	public List<StockItem> findAll();

	public StockItem save(StockItem stockItem);

}
