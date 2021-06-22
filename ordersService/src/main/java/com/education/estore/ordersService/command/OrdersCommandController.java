package com.education.estore.ordersService.command;

import com.education.estore.ordersService.command.rest.CreateOrderRestModel;
import com.education.estore.ordersService.core.OrderStatus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersCommandController {

    private final CommandGateway commandGateway;
    private static final String HARDCODED_USER_ID = "27b95829-4f3f-4ddf-8983-151ba010e35b";

    @Autowired
    public OrdersCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createOrder(@Valid @RequestBody CreateOrderRestModel createOrderRestModel) {
        CreateOrderCommand createOrderCommand = CreateOrderCommand.builder()
                .orderId(UUID.randomUUID().toString())
                .quantity((createOrderRestModel.getQuantity()))
                .productId(createOrderRestModel.getProductId())
                .addressId(createOrderRestModel.getAddressId())
                .userId(HARDCODED_USER_ID)
                .orderStatus(OrderStatus.CREATED)
                .build();
        return commandGateway.sendAndWait(createOrderCommand);
    }
}
