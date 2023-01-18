package com.example.activemq.SpringBootActiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ActiveMQTopicController {

    @Autowired
    PublisherService publisherService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email email) throws Exception {
        return publisherService.sendEmail(email);
    }
}
