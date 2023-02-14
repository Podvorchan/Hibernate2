package com.example.hibernate2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
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
public class Client {

  @Id
  private Integer id;

  @Column
  private String name;

  @Column
  private String email;

  @Column
  private String phone;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_address_id")
  private Address address;

  @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Order> ordersHistory;

}
