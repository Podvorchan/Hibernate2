package com.example.hibernate2.apiRepository;

import com.example.hibernate2.model.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 11.02.2023
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

  List<Client> findClientById(Integer id);
}
