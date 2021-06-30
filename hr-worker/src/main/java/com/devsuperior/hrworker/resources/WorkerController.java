package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAll(){
        List<Worker> workers = workerRepository.findAll();

        return ResponseEntity.ok().body(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id){
        Worker worker = workerRepository.findById(id).get();

        return ResponseEntity.ok().body(worker);
    }
}
