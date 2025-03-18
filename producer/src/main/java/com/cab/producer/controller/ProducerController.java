package com.cab.producer.controller;

import com.cab.producer.sender.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/producer")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @GetMapping("/{message}")
    public  String sendMessage(@PathVariable String message){
       producerService.sendMessage(message);
        return "OK";
    }
}
