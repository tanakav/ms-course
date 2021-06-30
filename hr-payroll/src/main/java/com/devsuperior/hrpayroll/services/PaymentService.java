package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;
    private RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(Long workerId, Integer days){
        Worker worker = getWorker(workerId);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    private Worker getWorker(Long workerId){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(
                workerHost.concat("/workers/{id}"),
                Worker.class,
                uriVariables);

        return worker;
    }

}
