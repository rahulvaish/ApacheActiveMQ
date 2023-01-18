package com.example.activemq.SpringBootActiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ActiveMQTopicController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/receiveEmail")
    public void getEmail() throws Exception {
        consumerService.getEmail();
    }
}
