package com.metaxiii.fr.feigntransfert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.metaxiii.fr")
public class FeignTransfertApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignTransfertApplication.class, args);
    }

}
