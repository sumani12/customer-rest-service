package com.rest.webservices.restfulwebservices.customer;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerDaoService service;

	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return service.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Resource<Customer> retrieveCustomer(@PathVariable int id) {
			Customer customer = service.findOne(id);
			
			if(customer==null)
				throw new CustomerNotFoundException("id-"+ id);
			
			
			Resource<Customer> resource = new Resource<Customer>(customer);
			
			ControllerLinkBuilder linkTo = 
					linkTo(methodOn(this.getClass()).retrieveAllCustomers());
			
			resource.add(linkTo.withRel("all-customers"));
			
			//HATEOAS
			
			return resource;
		}
		
		
	
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
		Customer savedCustomer = service.save(customer);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedCustomer.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}


}
