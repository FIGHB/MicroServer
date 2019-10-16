package com.stylefeng.guns.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
public class GunsPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsPaymentApplication.class, args);
    }
}
