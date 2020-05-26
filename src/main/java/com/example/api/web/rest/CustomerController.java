package com.example.api.web.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.setService(service);
	}
	@GetMapping("/Customer/editarCustomer")
	    public ModelAndView listarTodos() {
			ModelAndView modelAndView = new ModelAndView("EditarCustomer");
	        modelAndView.addObject("Customer", CustomerService.listarTodos());
	        return modelAndView;
		}
    // add
    @GetMapping("/Customer/cadastroCustomer")
    public ModelAndView cadastroCustomer(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("CadastroCustomer");
        modelAndView.addObject("Customer", customer);
        return modelAndView;
    }

    @GetMapping("/editarCustomer/{id}")
    public ModelAndView edit(@PathVariable("id") Customer id) {
        return cadastroCustomer(CustomerService.procurarPorId(id));
    }

    @GetMapping("/deletarCustomer/{id}")
    public ModelAndView delete(@PathVariable("id") Customer id) {
        CustomerService.delete(id);
        return new ModelAndView("redirect:/Customer/editarCustomer");

    }

    @PostMapping("/save")
    public ModelAndView cadastrar(@Valid Customer customer, BindingResult result, RedirectAttributes attribute) {
        System.out.println("O id é: "+ customer.getId());
        if (result.hasErrors()) {
            return this.cadastroCustomer(customer);
        } else {
            if (customer.getId() == null) {
                attribute.addFlashAttribute("mensagem", "Customer Cadastrado com sucesso!");
            } else {
                attribute.addFlashAttribute("mensagem", "Edição efetuada com sucesso!");
            }
            CustomerService.salvar(customer);
            return new ModelAndView("redirect:/Customer/cadastroCustomer");
        }

    }
	public CustomerService getService() {
		return service;
	}
	public void setService(CustomerService service) {
		this.service = service;
	}

}