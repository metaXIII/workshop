package com.metaxiii.fr.mapstruct.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilityEntity {
  @Id
  @GeneratedValue
  @Column
  private Long id;

  @Column(name = "utility_values")
  private String values;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  private ItemEntity item;
}
