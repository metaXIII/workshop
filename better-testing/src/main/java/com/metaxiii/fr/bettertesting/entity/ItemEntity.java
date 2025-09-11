package com.metaxiii.fr.bettertesting.entity;

import com.metaxiii.fr.bettertesting.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table
@Entity
public class ItemEntity {

  @Id
  private Long id;

  private String name;
  private String description;

  private StatusEnum status;

  private boolean isAvailable;
}
