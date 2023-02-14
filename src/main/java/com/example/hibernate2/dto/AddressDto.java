package com.example.hibernate2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 11.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

  private Integer id;

  private String country;

  private String city;

  private String street;

  private String house;

}
