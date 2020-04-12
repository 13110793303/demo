package com.cq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.cq.demo"})
public class AdminApplication {

    public static void main(String[] args) {
        List<String> m = new ArrayList<>();
        SpringApplication.run(AdminApplication.class, args);
    }


}
