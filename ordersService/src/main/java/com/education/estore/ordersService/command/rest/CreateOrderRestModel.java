package com.education.estore.ordersService.command.rest;

import lombok.Data;

@Data
public class CreateOrderRestModel {

    private final String productId;
    private final int quantity;
    private final String addressId;
}
