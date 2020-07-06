package ecom.product.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

	private long userId;
    private String name;
    private long contactNumber;

}
