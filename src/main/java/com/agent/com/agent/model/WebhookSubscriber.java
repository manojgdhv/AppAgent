package com.agent.com.agent.model;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

public class WebhookSubscriber {
    public String url;
    public RequestMethod method;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebhookSubscriber)) return false;
        WebhookSubscriber that = (WebhookSubscriber) o;
        return Objects.equals(url, that.url) &&
                method == that.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, method);
    }
}
