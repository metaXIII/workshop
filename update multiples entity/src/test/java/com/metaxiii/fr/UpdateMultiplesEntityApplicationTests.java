package com.metaxiii.fr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class UpdateMultiplesEntityApplicationTests {

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> UpdateMultiplesEntityApplication.main(new String[]{}));
    }

}
