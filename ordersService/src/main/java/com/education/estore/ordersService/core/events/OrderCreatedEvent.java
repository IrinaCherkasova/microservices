package com.education.estore.ordersService.core.events;

import com.education.estore.ordersService.core.OrderStatus;
import lombok.Data;

@Data
public class OrderCreatedEvent {

    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;
}
