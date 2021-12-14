package com.FApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.FApp.Exception.ResourceNotFoundException;
import com.FApp.model.Employee;
import com.FApp.repository.EmployeeRepo;
@CrossOrigin 
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
     @Autowired
	private EmployeeRepo employeeRepo;
     
     // get all Employees
     @GetMapping("/employees")
     public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
    	 
     }
     @PostMapping("/employees")
     public Employee createEmployee( @RequestBody Employee employees) {
		return employeeRepo.save(employees) ;
    	 
     }
     @GetMapping("/employees/{id}")
     public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
    	 Employee employee = employeeRepo.findById(id)
    			 .orElseThrow(() -> new ResourceNotFoundException("employee not Exist With "+id));
	
    	 return ResponseEntity.ok(employee);
     }
     
     @PutMapping("/employees/{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeedtl) {
    	 Employee employee = employeeRepo.findById(id)
    			 .orElseThrow(() -> new ResourceNotFoundException("employee not Exist With "+id));
    	 employee.setFirstname(employeedtl.getFirstname());
    	 employee.setLastname(employeedtl.getLastname());
    	 employee.setEmailid(employeedtl.getEmailid());
    	   
    	 Employee updatedEmployee = employeeRepo.save(employee);
    	 return ResponseEntity.ok(updatedEmployee);
     }
     
     //delete employee rest api
     @DeleteMapping("/employees/{id}")
     public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id) {
    	 Employee employee = employeeRepo.findById(id)
    			 .orElseThrow(() -> new ResourceNotFoundException("employee not Exist With "+id));
	  employeeRepo.delete(employee);
	  Map<String, Boolean> response = new HashMap<>();
	  response.put("deleted", Boolean.TRUE);
    	 return ResponseEntity.ok(response);
    	 
     }    
}
