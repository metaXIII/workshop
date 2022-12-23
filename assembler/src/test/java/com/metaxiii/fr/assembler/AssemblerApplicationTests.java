package com.metaxiii.fr.assembler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssemblerApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> AssemblerApplication.main(new String[]{}));
    }

}
