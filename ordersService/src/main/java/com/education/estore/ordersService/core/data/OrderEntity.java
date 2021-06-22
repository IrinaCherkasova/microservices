package com.education.estore.ordersService.core.data;

import com.education.estore.ordersService.core.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="orders")
public class OrderEntity implements Serializable {

    @Id
    @Column(unique = true)
    public String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}