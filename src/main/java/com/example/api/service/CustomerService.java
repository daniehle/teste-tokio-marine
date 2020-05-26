package com.example.api.service;

import javax.validation.Valid;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Repository
@Service
public class CustomerService {

	private static CustomerRepository repository;
	
	public static void salvar(@Valid Customer customer) {
		 repository.save(customer);
	}
	public static Iterable<Customer> listarTodos() {
		return repository.findAll();
	}

	public static void delete(Customer id) {
		repository.delete(id);
	}
	public static Customer procurarPorId(Customer id) {
        return repository.findOne(id);
    }

}
