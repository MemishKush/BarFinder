package com.project.barfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class BarfinderApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(BarfinderApplication.class, args);
    }

}
