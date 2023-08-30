package com.metaxiii.fr.record.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Item {

  private long id;
  private String propertyOne;
  private String propertyTwo;
  private String propertyThree;
  private String propertyFour;
  private String propertyFive;
  private String propertySix;
  private String propertySeven;
}
