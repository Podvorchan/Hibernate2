package com.example.hibernate2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Podvorchan Ruslan 07.02.2023
 */
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "my_store")
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "fk_order_id",nullable = false)
  @JsonIgnore
  private Order order;

  @ManyToOne
  @JoinColumn(name = "fk_product_id",nullable = false)
  private Product product;

  @Column
  private int count;

}
