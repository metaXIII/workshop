package com.metaxiii.fr.java1721.s17;

public record Record17CanonicalConstructor(String name, String description) {
  @SuppressWarnings({ "java:S1186", "java:S112" })
  public Record17CanonicalConstructor(final String name, final String description) {
    if (name.equals("gael")) {
      throw new RuntimeException();
    }
    this.name = name;
    this.description = description;
  }
}
