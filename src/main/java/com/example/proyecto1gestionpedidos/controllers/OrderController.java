package com.example.proyecto1gestionpedidos.controllers;

import com.example.proyecto1gestionpedidos.models.Pedido;
import com.example.proyecto1gestionpedidos.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Pedido createOrder(@RequestBody Pedido pedido) {
        System.out.println("Descripción: " + pedido.getDescription());
        System.out.println("Cantidad: " + pedido.getAmount());
        return orderService.createOrder(pedido);
    }

    @GetMapping
    public Iterable<Pedido> getAllOrders() {
        return orderService.findAllOrders();
    }

}
