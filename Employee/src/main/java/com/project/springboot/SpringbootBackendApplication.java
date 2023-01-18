package com.project.springboot;

import com.project.springboot.model.Employee;
import com.project.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

//    @Autowired
//    private EmployeeRepository employeeRepository;

}
//commandlineRunner implements a run method, it executes whenever a spring boot app starts first time
