package com.uta.employees.controller;

import com.uta.employees.dto.EmployeeDTO;
import com.uta.employees.model.Employee;
import com.uta.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployeesList(){
        List<Employee> employees =employeeService.getEmployeeList();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee =employeeService.createEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> getEmployeeDetail(@PathVariable(value = "id") Integer id){
        Employee employee=employeeService.getEmployeeDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO){
        Employee employee=employeeService.updateEmployee(id,employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping(value = "/employee/{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
            employeeService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        }
}

