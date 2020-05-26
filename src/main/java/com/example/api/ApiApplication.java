package com.example.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	@Bean
    public <ViaCEPCustomer, Endereco> CommandLineRunner run(ViaCEPCustomer customer){
        return args -> {
            if (args.length > 0) {
                
            	System.out.println("endereco,cep");
            }
        };
	
	}

}
