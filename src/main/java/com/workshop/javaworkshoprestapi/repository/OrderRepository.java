package com.workshop.javaworkshoprestapi.repository;

import com.workshop.javaworkshoprestapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
