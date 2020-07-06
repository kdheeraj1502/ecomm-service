package ecom.product.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecom.product.api.model.Product;
import ecom.product.api.model.ProductOrderRequest;
import ecom.product.api.service.impl.ProductServiceImpl;

@RestController
@RequestMapping(path = "/stockRequest")
public class StockRequestController {

	@Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductOrderRequest orderProductRequest) {
        for (Product product: orderProductRequest.getItems()) {

        	Optional<Product> item = productService.findById(product.getProductId());

            if (item.isPresent()) {
                return ResponseEntity.badRequest().body("Item is available" + product.getProductId());
            } else {
                productService.save(item.get());
            }
        }
        return ResponseEntity.ok("stock has been updated");
    }
}

