package ecom.product.api.model;

import java.util.List;

import org.springframework.stereotype.Component;

import ecom.product.api.constants.Status;
import ecom.product.api.entity.RootEntity;
import ecom.product.api.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Order extends RootEntity {

    private List<OrderedProduct> orderedProducts;
    private Status status;
    private User user;

    public Order(Status status, User user) {
        this.status = status;
        this.user = user;
    }
}
