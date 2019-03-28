package com.agent.controller;

import com.agent.com.agent.model.WebhookSubscriber;
import com.agent.service.WebhookSubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;


@RestController
public class RegistrationController {

    @Autowired private WebhookSubscriberService subscriverService;

    @RequestMapping("/")
    public String index() {
        return "Welcome to webhook registration!";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> register(@RequestBody WebhookSubscriber subscriber) {
        subscriverService.register(subscriber);
        return ResponseEntity.ok().body("Successfully subscribed to webhook!");
    }

    @RequestMapping(value = "/subscribers", method = RequestMethod.GET)
    public Set<WebhookSubscriber> subscribers() {
        return subscriverService.getSubscribers();
    }

}
