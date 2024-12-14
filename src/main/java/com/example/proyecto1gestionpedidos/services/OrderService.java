package com.example.proyecto1gestionpedidos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.proyecto1gestionpedidos.repository.OrderRepository;
import com.example.proyecto1gestionpedidos.models.Pedido;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    public Pedido createOrder(Pedido pedido) {
        return orderRepository.save(pedido);
    }
    @Transactional(readOnly = true)
    public Iterable<Pedido> findAllOrders() {
        return orderRepository.findAll();
    }
    @Transactional(rollbackFor = Exception.class)
    public  void updateOrder(Pedido pedido) throws Exception {
        orderRepository.save(pedido);
        if (someConditionFails()) {
            throw new Exception("Simulated error");
        }
    }
    private boolean someConditionFails() {
        return true;
    }
}

