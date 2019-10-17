package com.alipay.demo.trade;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.alipay.demo.trade"})
@EnableDubboConfiguration
public class GunsPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsPaymentApplication.class, args);
    }
}
