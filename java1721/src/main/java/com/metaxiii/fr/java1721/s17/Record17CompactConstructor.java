package com.metaxiii.fr.java1721.s17;

public record Record17CompactConstructor(String name, String description) {
  @SuppressWarnings("java:S112")
  public Record17CompactConstructor {
    if (name.equals("gael")) {
      throw new RuntimeException();
    }
  }
}
