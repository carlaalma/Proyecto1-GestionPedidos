package com.example.proyecto1gestionpedidos.controllers;

import com.example.proyecto1gestionpedidos.models.Order;
import com.example.proyecto1gestionpedidos.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderService.findAllOrders();
    }


}
