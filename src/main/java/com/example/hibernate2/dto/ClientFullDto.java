package com.example.hibernate2.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 11.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFullDto {

  private Integer id;

  private String name;

  private String email;

  private String phone;

  private AddressDto address;

  private List<OrderDto> ordersHistory;

}
