package com.metaxiii.fr.java1721;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class S21Test {

  /*
    itShouldJsonBlock
    itShouldShowSequence
   */

//  @Test
//  void itShouldJsonBlock() {
//    final var jsonBlock =
//        """
//            {
//              "name" : "{ name }",
//              "lastName": "Smith",
//              "profession": "PR destroyer",
//              "age": 20
//            }""";
//    System.out.println(jsonBlock);
//    final var name = "Gaël";
//    System.out.println(STR."{\n  \"name\" : \{name},\n  \"lastName\": \"Smith\",\n  \"profession\": \"PR destroyer\",\n  \"age\": 20\n}");
//
//    System.out.println(STR."""
//        {
//              "name" : "\{name}",
//              "lastName": "Smith",
//              "profession": "PR destroyer",
//              "age": 20
//            }""");
//  }

  @Test
  void itShouldShowSequence() {
    final var list = new ArrayList<>(Arrays.asList(1, 2, 3));
    System.out.println(list.reversed());
    list.addFirst(-1);
    System.out.println(list);
    list.addLast(5);
    System.out.println(list);

    System.out.println(list.getFirst());
    System.out.println(list.getLast());

    list.removeFirst();
    System.out.println(list);

    list.removeLast();
    System.out.println(list);
  }

  @Test
  void itShouldUseVirtualThread() {
    //Before the introduction of Virtual Threads, the Threads we’re used to, java.lang.Thread, were backed so-called platform threads.
    //
    //These threads are typically mapped 1:1 to kernel threads scheduled by the OS. OS threads are quite “heavy”. That makes them suitable for executing all types of tasks.
    //
    //Depending on the OS and configuration, they consume somewhere between 2 and 10 MB by default. So if you want to utilize a million threads in your heavy-load concurrent application, you better have more than 2 TB of memory to spare!
    try (final var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 1000; i++) {

        int taskNumber = i;
        executor.submit(() -> {
          System.out.println("Task " + taskNumber + " is running in a virtual thread!");
        });
      }

      executor.shutdown();
    } catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }

  @Nested
  @SuppressWarnings("ConstantValue")
  class PatternMatchingWithJava21 {

    @Test
    void itShouldMatch() {
      final Object obj = new Developer("myself");
      if (obj instanceof Developer(String otherName)) {
        assertEquals("myself", otherName);
      }
    }

    private record Developer(String name) {
    }
  }
}
