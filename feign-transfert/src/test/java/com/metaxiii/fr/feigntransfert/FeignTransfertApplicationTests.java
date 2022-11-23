package com.metaxiii.fr.feigntransfert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeignTransfertApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> FeignTransfertApplication.main(new String[]{}));
    }

}
