package com.example.hibernate2.service;

import static java.util.stream.Collectors.toList;

import com.example.hibernate2.dto.ClienOrderInfoDto;
import com.example.hibernate2.dto.ClientFullDto;
import com.example.hibernate2.dto.ClientInfoDto;
import com.example.hibernate2.apiRepository.ClientRepository;
import com.example.hibernate2.dto.ClientDto;
import com.example.hibernate2.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 12.02.2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

  private final ClientRepository clientRepository;
  private final ObjectMapper objectMapper;

  public ClientDto createClient(ClientDto clientDto) {
    Client client = objectMapper.convertValue(clientDto, Client.class);
    clientRepository.save(client);
    clientDto.setId(client.getId());
    log.info("Client id:{} created", clientDto.getId());
    return clientDto;
  }

  public List<ClientFullDto> findFullClientInfoById(Integer clientId) {
    var clients = clientRepository.findClientById(clientId);
    return clients.stream()
        .map(c -> objectMapper.convertValue(c, ClientFullDto.class))
        .collect(toList());
  }

  public List<ClientInfoDto> findClientInfoById(Integer clientId) {
    var clients = clientRepository.findClientById(clientId);
    return clients.stream()
        .map(c -> objectMapper.convertValue(c, ClientInfoDto.class))
        .collect(toList());
  }

  public List<ClienOrderInfoDto> findClientOrderInfoById(Integer clientId) {
    var clients = clientRepository.findClientById(clientId);
    return clients.stream()
        .map(c -> objectMapper.convertValue(c, ClienOrderInfoDto.class))
        .collect(toList());
  }

}
