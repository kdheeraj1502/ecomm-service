package ecom.product.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ecom.product.api.service.impl"})
public class ProductEcomServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductEcomServiceApplication.class, args);
	}

}
