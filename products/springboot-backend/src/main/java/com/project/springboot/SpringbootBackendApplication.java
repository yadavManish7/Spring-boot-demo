package com.project.springboot;

import com.project.springboot.model.Employee;
import com.project.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
       /* Employee employeeObj = new Employee();
        employeeObj.setFirstName("John");
        employeeObj.setLastName("Wood");
        employeeObj.setEmailId("wood.john127@yahoo.com");
        employeeRepository.save(employeeObj); //to save employeeObj to the database

        Employee employeeObj1 = new Employee();
        employeeObj1.setFirstName("Julia");
        employeeObj1.setLastName("Marsh");
        employeeObj1.setEmailId("Marsh.julia110@gmail.com");
        employeeRepository.save(employeeObj1); */
    }
}
//commandlineRunner implements a run method, it executes whenever a spring boot app starts first time
