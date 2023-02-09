package com.metaxiii.fr.mapstruct.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
  private Long id;
  private String name;
  private double value;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
