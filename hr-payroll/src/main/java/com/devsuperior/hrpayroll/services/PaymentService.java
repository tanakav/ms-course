package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient){
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(Long workerId, Integer days){
        Worker worker = getWorker(workerId);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    private Worker getWorker(Long workerId){
        Worker worker = workerFeignClient.getById(workerId).getBody();

        return worker;
    }

}
