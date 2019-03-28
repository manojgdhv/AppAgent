package com.agent.service;

import com.agent.com.agent.model.WebhookSubscriber;
import com.agent.util.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookPublisherService {
    @Autowired
    private WebhookSubscriberService subscriberService;
    @Autowired
    private Publisher publisher;

    public void publish() {
        subscriberService.getSubscribers().stream()
                .forEach(subscriber -> publisher.publish(subscriber));
    }
}
