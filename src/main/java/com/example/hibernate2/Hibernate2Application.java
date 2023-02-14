package com.example.hibernate2;

import com.example.hibernate2.dto.ClienOrderInfoDto;
import com.example.hibernate2.dto.ClientDto;
import com.example.hibernate2.dto.ClientFullDto;
import com.example.hibernate2.dto.ClientInfoDto;
import com.example.hibernate2.dto.ProductDto;
import com.example.hibernate2.service.ClientService;
import com.example.hibernate2.service.Servise;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Hibernate2Application {

  private final ClientService clientService;
  private final Servise service;


  public static void main(String[] args) {
    SpringApplication.run(Hibernate2Application.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void init() {

    ProductDto cocaCola = new ProductDto(1, "Coca-Cola", "Sweet sparkling water", 38.50);
    ProductDto pepsi = new ProductDto(2, "Pepsi", "Sweet sparkling water", 40.0);
    ProductDto borgomi = new ProductDto(3, "Borgomi", "Mineral water", 69.3);
    ProductDto redBull = new ProductDto(4, "RedBull", "Energy drink", 59.0);
    service.createProduct(cocaCola);
    service.createProduct(pepsi);
    service.createProduct(borgomi);
    service.createProduct(redBull);

    var ruslanClient = new ClientDto(1, "Ruslan", "porubo@ukr.net", "+380997763229");
    ClientDto client = clientService.createClient(ruslanClient);

    List<ClientFullDto> fullClientInfoById = clientService.findFullClientInfoById(1);
    log.info("All info about client: {}", fullClientInfoById);

    List<ClientInfoDto> clientInfoById = clientService.findClientInfoById(1);
    log.info("Info about client: {}", clientInfoById);

    List<ClienOrderInfoDto> clientOrderInfoById = clientService.findClientOrderInfoById(1);
    log.info("Info about client and order: {}", clientOrderInfoById);
  }
}
