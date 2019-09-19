package com.everis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@EnableSwagger2WebFlux
@SpringBootApplication
public class MicroserviceBApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceBApplication.class, args);
  }

}
