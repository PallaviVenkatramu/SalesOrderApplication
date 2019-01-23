package com.order.controller;

import com.order.Model.Order;
import com.order.Repository.OrderRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRESTController {


    private OrderRepository orderRepository;
    public OrderRESTController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(
        value="/order/create",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )

    public void create(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @RequestMapping(
            value="/order/{id}/delete",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public void delete(@PathVariable Long id) {
        orderRepository.delete(id);
    }

    @RequestMapping(
            value="/order/getAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @RequestMapping(
            value="/order/edit",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public void edit(@RequestBody Order order) {
        orderRepository.save(order);
    }
}
