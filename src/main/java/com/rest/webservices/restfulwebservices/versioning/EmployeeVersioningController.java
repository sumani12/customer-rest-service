package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeVersioningController {
	
	@GetMapping("v1/employee")
	public Employeev1 employeev1() {
		return new Employeev1("James Tucker");
	}
	
	@GetMapping("v2/employee")
	public Employeev2 employeev2() {
		return new Employeev2(new Name("James" , "Tucker"));
	}
	
	@GetMapping(value = "/employee/param", params = "version=1")
	public Employeev1 paramv1() {
		return new Employeev1("James Tucker");
	}
	
	@GetMapping(value = "/employee/param", params = "version=2")
	public Employeev2 paramv2() {
		return new Employeev2(new Name("James", "Tucker"));
	}
	
	@GetMapping(value = "/employee/header", headers = "X-API-VERSION=1")
	public Employeev1 headerV1() {
		return new Employeev1("Bob Charlie");
	}
	
	@GetMapping(value = "/employee/header", headers = "X-API-VERSION=2")
	public Employeev2 headerV2() {
		return new Employeev2(new Name("James", "Tucker"));
	}	
		
     @GetMapping(value = "/employee/produces", produces = "application/vnd.company.app-v1+json")
	 public Employeev1 producesV1() {
		 return new Employeev1("James Tucker");
	}

	 @GetMapping(value = "/employee/produces", produces = "application/vnd.company.app-v2+json")
	 public Employeev2 producesV2() {
		 return new Employeev2(new Name("James", "Tucker"));
	}	
	

}
