package com.example.hibernate2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class Address {

  @Id
  private Integer id;
  @OneToOne(mappedBy = "address")
  @JsonIgnore
  private Client client;
  @Column
  private String country;

  @Column
  private String city;

  @Column
  private String street;

  @Column
  private String house;



}
