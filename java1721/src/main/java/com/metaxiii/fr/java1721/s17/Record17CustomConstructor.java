package com.metaxiii.fr.java1721.s17;

public record Record17CustomConstructor(String name, String description) {
  public Record17CustomConstructor(final String name) {
    this(name, "default description");
  }
}
