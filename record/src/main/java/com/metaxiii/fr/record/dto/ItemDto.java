package com.metaxiii.fr.record.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ItemDto {

  private String propertyOne;
  private String propertyTwo;
  private String propertyThree;
  private String propertyFour;
  private String propertyFive;
  private String propertySix;
  private String propertySeven;
}
