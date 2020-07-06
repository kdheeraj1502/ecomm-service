package ecom.product.api.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class User {

	private long userId;
    private String name;
    private long contactNumber;

}
