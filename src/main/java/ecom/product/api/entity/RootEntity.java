package ecom.product.api.entity;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RootEntity {

    private Long id;
    private Date createdAt;
    private Date modifiedAt;

    public ZonedDateTime getModifiedAt() {
        return ZonedDateTime.ofInstant(modifiedAt.toInstant(), ZoneId.systemDefault());
    }
}
