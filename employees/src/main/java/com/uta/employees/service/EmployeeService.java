package com.uta.employees.service;


import com.uta.employees.dto.EmployeeDTO;
import com.uta.employees.exception.EmployeeNotFoundException;
import com.uta.employees.model.Employee;
import com.uta.employees.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getEmployeeList() {
        return employeeRepo.findAll();
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail(), employeeDTO.getPhoneNum(), employeeDTO.getSalary(), employeeDTO.getPosition());
        return employeeRepo.save(employee);
    }

    public Employee getEmployeeDetail(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new EmployeeNotFoundException(String.format("Employee with id %d does not exist", id), 404);
        }
    }

    public Employee updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employeeToUpdate = optionalEmployee.get();
            employeeToUpdate.setFirstName(employeeDTO.getFirstName());
            employeeToUpdate.setLastName(employeeDTO.getLastName());
            employeeToUpdate.setEmail(employeeDTO.getEmail());
            employeeToUpdate.setSalary(employeeDTO.getSalary());
            employeeToUpdate.setPosition(employeeDTO.getPosition());
            employeeToUpdate.setPhoneNum(employeeDTO.getPhoneNum());
            return employeeRepo.save(employeeToUpdate);
        } else {
            throw new EmployeeNotFoundException(String.format("Employee with id %d does not exist", id), 404);
        }
    }

    public void deleteEmployee(Integer id) {
        try {
            employeeRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException(String.format("Employee with id %d does not exist", id), 404);
        }

    }
}