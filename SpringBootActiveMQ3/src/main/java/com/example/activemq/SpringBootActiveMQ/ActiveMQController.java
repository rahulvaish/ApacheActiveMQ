package com.example.activemq.SpringBootActiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ActiveMQController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/receiveEmail")
    public void receiveEmail() throws Exception {
        consumerService.receiveEmail();
    }
}
