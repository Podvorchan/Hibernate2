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
public class OrderItemDto {

  private Integer id;

  private ProductDto product;

  private int count;


}
