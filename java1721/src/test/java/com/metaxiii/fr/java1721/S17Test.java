package com.metaxiii.fr.java1721;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.metaxiii.fr.java1721.s17.Record17CanonicalConstructor;
import com.metaxiii.fr.java1721.s17.Record17CompactConstructor;
import com.metaxiii.fr.java1721.s17.Record17CustomConstructor;
import com.metaxiii.fr.java1721.s17.Record17Standard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class S17Test {

  /*
    run in order :
    itShouldJsonBlock
    itShouldImprovedSwitch_v1_1
    itShouldImprovedSwitch_v1_2
    itShouldImprovedSwitch_v1_3
    itShouldImprovedSwitch_v2_1
    itShouldImprovedSwitch_v2_2
    itShouldImprovedSwitch_v2_3
    itShouldUseRecord
    itShouldTestCompactConstructor
    itShouldTestCanonicalConstructor
    itShouldUseCustomConstructorRecord
    NonSealedInterface1
    SealedInterface2
    PatternMatchingWithJava11_3
    PatternMatchingWithJava17_4

   */

  private S17 mainClass;

  @BeforeEach
  public void beforeEach() {
    mainClass = new S17();
  }

  @Test
  void itShouldImprovedSwitch_v1_1() {
    assertEquals("A", mainClass.improvedSwitch_v1(1));
  }

  @Test
  void itShouldImprovedSwitch_v1_2() {
    assertEquals("B", mainClass.improvedSwitch_v1(2));
  }

  @Test
  void itShouldImprovedSwitch_v1_3() {
    assertEquals("C", mainClass.improvedSwitch_v1(3));
  }

  @Test
  void itShouldImprovedSwitch_v2_1() {
    assertEquals("A", mainClass.improvedSwitch_v2(1));
  }

  @Test
  void itShouldImprovedSwitch_v2_2() {
    assertEquals("B", mainClass.improvedSwitch_v2(2));
  }

  @Test
  void itShouldImprovedSwitch_v2_3() {
    assertEquals("C", mainClass.improvedSwitch_v2(3));
  }

  @Test
  @SuppressWarnings({ "java:S6126", "TextBlockMigration" })
  void itShouldJsonBlock() {
    final var result = mainClass.jsonBlock();
    assertEquals(
      "{\n" +
      "  \"name\" : \"Gaël\",\n" +
      "  \"lastName\": \"Smith\",\n" +
      "  \"profession\": \"PR destroyer\",\n" +
      "  \"age\": 20\n" +
      "}",
      result
    );
  }

  @Test
  void itShouldTestCanonicalConstructor() {
    assertThrows(RuntimeException.class, () -> new Record17CanonicalConstructor("gael", "it will fail"));
  }

  @Test
  void itShouldTestCompactConstructor() {
    assertThrows(RuntimeException.class, () -> new Record17CompactConstructor("gael", "it will fail"));
  }

  @Test
  void itShouldUseCustomConstructorRecord() {
    final var rec1 = new Record17CustomConstructor("name");
    assertEquals("name", rec1.name());
    assertEquals("default description", rec1.description());

    final var rec2 = new Record17CustomConstructor("name", "desc");
    assertEquals("name", rec2.name());
    assertEquals("desc", rec2.description());
  }

  @Test
  void itShouldUseRecord() {
    final var rec = new Record17Standard("name", "desc");
    assertEquals("name", rec.name());
    assertEquals("desc", rec.description());
  }

  @Nested
  class NonSealedInterface1 {

    @Test
    void itShouldEat() {
      assertDoesNotThrow(() -> {
        final var apple = new Apple();
        apple.eat(); //ok

        final var dev = new Developer();
        dev.eat(); //ok but it should not be
      });
    }

    private abstract static class Fruit {

      protected void eat() {
        System.out.println("I can be eaten");
      }
    }

    private static class Apple extends Fruit {}

    private static class Developer extends Fruit {}
  }

  @Nested
  class SealedInterface2 {

    @Test
    void itShouldEat() {
      assertDoesNotThrow(() -> {
        final var apple = new Apple();
        apple.eat(); //ok

        final var pizza = new Pizza();
        pizza.eat(); //ok

        final var dev = new Developer();
        //dev cannot be eaten anymore
        //dev.eat(); //ok but it should not be
      });
    }

    private abstract static sealed class Fruit permits Apple, Pizza {

      protected void eat() {
        System.out.println("I can be eaten");
      }
    }

    private static final class Apple extends Fruit {}

    private static non-sealed class Pizza extends Fruit {}

    private static class Developer {}
  }

  @Nested
  @SuppressWarnings("ConstantValue")
  class PatternMatchingWithJava11_3 {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    void itShouldMatch() {
      final Object obj = new Developer("myself");
      if (obj instanceof Developer) {
        final var dev = (Developer) obj;
        assertEquals("myself", dev.name());
      }
    }

    private record Developer(String name) {}
  }

  @Nested
  @SuppressWarnings("ConstantValue")
  class PatternMatchingWithJava17_4 {

    @Test
    void itShouldMatch() {
      final Object obj = new Developer("myself");
      if (obj instanceof final Developer dev) {
        assertEquals("myself", dev.name());
      }
    }

    private record Developer(String name) {}
  }
}
