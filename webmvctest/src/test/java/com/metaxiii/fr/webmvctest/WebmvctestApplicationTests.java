package com.metaxiii.fr.webmvctest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebmvctestApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> WebmvctestApplication.main(new String[]{}));
    }

}
