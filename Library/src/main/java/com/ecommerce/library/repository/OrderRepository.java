package com.ecommerce.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.library.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
