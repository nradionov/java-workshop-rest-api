package com.workshop.javaworkshoprestapi.controller;

import com.workshop.javaworkshoprestapi.api.OrdersApi;
import com.workshop.javaworkshoprestapi.model.Order;
import com.workshop.javaworkshoprestapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController implements OrdersApi {

    private OrderRepository repository;

    @Autowired
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order get(@PathVariable("id") String id) {
        Optional<Order> order = repository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    public Order create(@RequestBody Order order) {
        if (order != null) {
            order.setOrigin(order.getLocation());
            return repository.save(order);
        }
        return null;
    }

    public Order update(@PathVariable("id") String id, @RequestBody Order order) {
        Optional<Order> dbOrder = repository.findById(id);
        if (dbOrder.isPresent()) {
            order.setId(dbOrder.get().getId());
            return repository.save(order);
        }
        return null;
    }

    public void remove(@PathVariable("id") String id) {
        Optional<Order> dbOrder = repository.findById(id);
        if (dbOrder.isPresent()) {
            repository.deleteById(id);
        }
    }
}