package com.revature.beats_ahoy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication // this is @Configuration, @ComponentScan and @EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class beatsAhoyApplication {


    public static void main(String[] args) {
        SpringApplication.run(beatsAhoyApplication.class, args);
    }
}


