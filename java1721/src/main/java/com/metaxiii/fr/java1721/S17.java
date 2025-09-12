package com.metaxiii.fr.java1721;

@SuppressWarnings("java:S106")
public class S17 {

  public String improvedSwitchV1(final int choice) {
    return switch (choice) {
      case 1:
        yield "A";
      case 2:
        yield "B";
      default:
        System.out.println("Default case");
        yield "C";
    };
  }

  public String improvedSwitchV2(final int choice) {
    return switch (choice) {
      case 1 -> "A";
      case 2 -> "B";
      default -> {
        System.out.println("Default case");
        yield "C";
      }
    };
  }

  public String jsonBlock() {
    return """
    {
      "name" : "Gaël",
      "lastName": "Smith",
      "profession": "PR destroyer",
      "age": 20
    }""";
  }
}
