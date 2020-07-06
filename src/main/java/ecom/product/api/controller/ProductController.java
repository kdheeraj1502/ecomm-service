package ecom.product.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecom.product.api.model.Product;
import ecom.product.api.service.impl.ProductServiceImpl;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

	@Autowired
    private ProductServiceImpl productService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
    	Product inserted = productService.save(product);
        return ResponseEntity.ok(inserted);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product) {
    	Product updated = productService.save(product);
        return ResponseEntity.ok(updated);
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
    	Optional<Product> product = productService.findById(id);
        if(product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
        productService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
