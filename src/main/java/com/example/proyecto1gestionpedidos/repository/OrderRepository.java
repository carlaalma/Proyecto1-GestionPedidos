package com.example.proyecto1gestionpedidos.repository;
import com.example.proyecto1gestionpedidos.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Pedido, Long> {

}
