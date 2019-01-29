package com.nu.automentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AutoMentorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoMentorApplication.class, args);
    }

}

