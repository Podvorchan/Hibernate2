package com.example.hibernate2.service;


import com.example.hibernate2.apiRepository.ClientRepository;
import com.example.hibernate2.dto.OrderDto;
import com.example.hibernate2.dto.ProductDto;
import com.example.hibernate2.apiRepository.AddressRepository;
import com.example.hibernate2.apiRepository.OrderItemRepository;
import com.example.hibernate2.apiRepository.OrderRepository;
import com.example.hibernate2.apiRepository.ProductRepository;
import com.example.hibernate2.dto.AddressDto;
import com.example.hibernate2.dto.ClientDto;
import com.example.hibernate2.model.Address;
import com.example.hibernate2.model.Client;
import com.example.hibernate2.model.Order;
import com.example.hibernate2.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 13.02.2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class Servise {

  private final ClientRepository clientRepository;
  private final AddressRepository addressRepository;
  private final ObjectMapper objectMapper;
  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;
  private final ProductRepository productRepository;


  public ProductDto createProduct(ProductDto productDto) {
    Product product = objectMapper.convertValue(productDto, Product.class);
    productRepository.save(product);
    productDto.setId(product.getId());
    log.info("Product id:{} created", productDto.getId());
    return productDto;

  }

  public AddressDto addAddress(ClientDto clientDto, AddressDto addressDto) {
    Address address = objectMapper.convertValue(addressDto, Address.class);
    Client client = objectMapper.convertValue(clientDto, Client.class);
    client.setAddress(address);
    clientRepository.save(client);
    log.info("Client id:{} add Address", clientDto.getId());
    return addressDto;
  }

  public OrderDto addOrder(ClientDto clientDto) {
    var orderModel = new Order();
    Client client = objectMapper.convertValue(clientDto, Client.class);
    orderModel.setClient(client);
    orderRepository.save(orderModel);
    log.info("Client id:{} add Order", clientDto.getId());
    return objectMapper.convertValue(orderModel, OrderDto.class);
  }

}

