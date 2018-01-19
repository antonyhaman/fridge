package com.github.kotvertolet.fridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.github.kotvertolet.fridge.config.AppConfig;

@EnableWebMvc
@SpringBootApplication
@Import({AppConfig.class})
@ComponentScan
public class FridgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FridgeApplication.class, args);
    }
}
