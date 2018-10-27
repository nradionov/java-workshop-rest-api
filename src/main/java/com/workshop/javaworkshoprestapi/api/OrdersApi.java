package com.workshop.javaworkshoprestapi.api;

import com.workshop.javaworkshoprestapi.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/orders")
public interface OrdersApi {

    //GET http://localhost:8080/api/orders
    @GetMapping
    List<Order> getAll();

    //GET http://localhost:8080/api/orders/{id}
    @GetMapping("/{id}")
    Order get(@PathVariable("id") String id);

    //POST http://localhost:8080/api/orders
    @PostMapping
    Order create(@RequestBody Order order);

    //PUT http://localhost:8080/api/orders/{id}
    @PutMapping("/{id}")
    Order update(@PathVariable("id") String id, @RequestBody Order order);

    //DELETE http://localhost:8080/api/orders/{id}
    @DeleteMapping("/{id}")
    void remove(@PathVariable("id") String id);
}
