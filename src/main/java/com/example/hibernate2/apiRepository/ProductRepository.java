package com.example.hibernate2.apiRepository;

import com.example.hibernate2.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 11.02.2023
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
