package com.example.hibernate2.dto;

import com.example.hibernate2.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 11.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDto {

  private Integer id;

  private String name;

  private String email;

  private String phone;

  private AddressDto address;


}
