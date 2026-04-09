package com.coding.prasoon.module1Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

    @Autowired
    PaymentService paymentService;

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);
        //PaymentService paymentService = new PaymentService();  this is not required if we used @autowired then sprint will take care of it



	}

    @Override
    public void run(String... args) throws Exception {
        paymentService.pay();
    }
}
