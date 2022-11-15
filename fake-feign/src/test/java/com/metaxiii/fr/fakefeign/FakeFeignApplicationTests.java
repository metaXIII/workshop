package com.metaxiii.fr.fakefeign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class FakeFeignApplicationTests {
    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> FakeFeignApplication.main(new String[]{}));
    }
}
