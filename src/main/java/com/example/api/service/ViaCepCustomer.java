package com.example.api.service;

import org.springframework.web.client.RestTemplate;


public class ViaCepCustomer<Endereco> {
	public ViaCepCustomer<?> buscaEnderecoPor(String Cep){
        RestTemplate template = new RestTemplate();
        return template.getForObject("https://viacep.com.br/ws/{cep}/json",ViaCepCustomer.class, Cep);
    }
}
