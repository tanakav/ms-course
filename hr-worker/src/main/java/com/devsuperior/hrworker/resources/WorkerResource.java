package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.entities.Employee;
import com.devsuperior.hrworker.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    private Environment env;
    private EmployeeRepository employeeRepository;

    public WorkerResource(EmployeeRepository employeeRepository, Environment env){
        this.employeeRepository = employeeRepository;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> workers = employeeRepository.findAll();

        return ResponseEntity.ok().body(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        logger.info("PORT = "+env.getProperty("local.server.port"));

        Employee worker = employeeRepository.findById(id).get();
        return ResponseEntity.ok().body(worker);
    }
}
