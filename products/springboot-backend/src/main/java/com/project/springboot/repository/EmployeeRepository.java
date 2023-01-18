package com.project.springboot.repository;

import com.project.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //JpaRepository accepts two parameters, JpaEntity and JpaEntity type
    //all CRUD database methods to interact with database

}
