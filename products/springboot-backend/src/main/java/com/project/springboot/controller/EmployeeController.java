package com.project.springboot.controller;

import com.project.springboot.exception.ResourceNotFoundException;
import com.project.springboot.model.Employee;
import com.project.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")     //base URL for all APIs
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {   //entity employee class
        return employeeRepository.findAll(); //to fetch from database use repo
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){  //Return type is Employee
        return employeeRepository.save(employee);  //save() takes entity object
    }

    @GetMapping("{id}")  //make sure it matches with the argument in the method
    public ResponseEntity<Employee> getEmpById(@PathVariable long id){
         Employee employeeObj = employeeRepository.findById(id)
                 .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id " + id)); //lambda expression
        return ResponseEntity.ok(employeeObj);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee employeeObj1 =employeeRepository.findById(id).    //fetch emp obj from database
                orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));
        employeeObj1.setFirstName(employeeDetails.getFirstName());
        employeeObj1.setLastName(employeeDetails.getLastName());
        employeeObj1.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(employeeObj1);  //to save updated value to the database
        return ResponseEntity.ok(employeeObj1); //returning to the client

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmp(@PathVariable long id){
        Employee employeeObj2 = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id" + id));
        employeeRepository.delete(employeeObj2);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

//@RequestBody will convert JSON into Java object
//@ResponseEntity<> is a generic class, it takes type:Employee
//@PathVariable to bind the value of the argument
