package com.devsuperior.hrworker.repositories;


import com.devsuperior.hrworker.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
