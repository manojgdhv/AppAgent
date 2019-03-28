package com.agent.service;

import com.agent.com.agent.model.WebhookSubscriber;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WebhookSubscriberService {
    private Set<WebhookSubscriber> subscribers = new HashSet<>();

    public void register(WebhookSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public Set<WebhookSubscriber> getSubscribers() {
        return subscribers;
    }
}
