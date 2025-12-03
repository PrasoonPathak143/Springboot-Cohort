package com.coding.prasoon.module1Introduction;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
@Component
public class PaymentService {
    public void pay(){
        System.out.println("Paying...");
    }

    @PostConstruct
    public void beforeUse(){
        System.out.println("Post Construct");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("Before Destroy");
    }
}
