package com.example.proyecto1gestionpedidos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.proyecto1gestionpedidos.repository.OrderRepository;
import com.example.proyecto1gestionpedidos.models.Order;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    @Transactional(readOnly = true)
    public Iterable<Order> findAllOrders() {
        return orderRepository.findAll();
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Order order) throws Exception {
        orderRepository.save(order);
        if (someConditionFails()) {
            throw new Exception("Simulated error");
        }
    }
    private boolean someConditionFails() {
        // Simula una condición que falla
        return true;
    }
}

