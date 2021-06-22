package com.education.estore.ordersService.query;

import com.education.estore.ordersService.core.data.OrderEntity;
import com.education.estore.ordersService.core.data.OrdersRepository;
import com.education.estore.ordersService.core.events.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler {

    private final OrdersRepository ordersRepository;

    public OrderEventsHandler(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) throws Exception {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);
        try {
            ordersRepository.save(orderEntity);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        //throw new Exception("An error in Order EventsHandler");
    }

    @ExceptionHandler(resultType = IllegalArgumentException.class)
    public void handle(IllegalArgumentException ex) {
        throw ex;
    }

    @ExceptionHandler()
    public void handle(Exception ex) throws Exception {
        throw ex;
    }
}
