package com.example.proyecto1gestionpedidos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.proyecto1gestionpedidos.models.Pedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import
        org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.proyecto1gestionpedidos.services.OrderService;
@SpringBootTest
@AutoConfigureMockMvc

public class OrderControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrderService orderService;
    @Test
    public void testCreateOrder() throws Exception {
        String orderJson = "{\"id\": 1, \"description\": \"Test Order\", \"amount\": 100.0}";
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isOk());
    }
    @Test
    public void testUpdateOrderWithError() {
        Pedido order = new Pedido(1L, "Test Order", 100.0);
        assertThrows(Exception.class, () -> {
            orderService.updateOrder(order);
        });
    }
}
