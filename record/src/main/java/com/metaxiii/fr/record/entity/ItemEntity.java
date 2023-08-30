package com.metaxiii.fr.record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemEntity {

  @Id
  @GeneratedValue
  private long id;

  @Column
  private String propertyOne;

  @Column
  private String propertyTwo;

  @Column
  private String propertyThree;

  @Column
  private String propertyFour;

  @Column
  private String propertyFive;

  @Column
  private String propertySix;

  @Column
  private String propertySeven;
}
