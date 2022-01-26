package ru.hogwards.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition
public class MagicWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MagicWebAppApplication.class, args);
    }

}
