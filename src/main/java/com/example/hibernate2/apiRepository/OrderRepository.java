package com.example.hibernate2.apiRepository;

import com.example.hibernate2.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 11.02.2023
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
