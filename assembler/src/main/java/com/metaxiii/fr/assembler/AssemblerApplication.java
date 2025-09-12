package com.metaxiii.fr.assembler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.metaxiii.fr")
public class AssemblerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssemblerApplication.class, args);
  }
}
