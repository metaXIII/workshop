package com.metaxiii.fr.exceptiontesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.metaxiii.fr.exceptiontesting")
public class ExceptionTestingApp {

  public static void main(String[] args) {
    SpringApplication.run(ExceptionTestingApp.class, args);
  }
}
