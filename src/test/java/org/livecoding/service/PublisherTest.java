package org.livecoding.service;

import org.junit.jupiter.api.Test;
import org.livecoding.component.bublishersubscriber.NewsPublisher;
import org.livecoding.component.bublishersubscriber.NewsSubscriber;
import org.livecoding.component.bublishersubscriber.Publisher;
import org.livecoding.component.bublishersubscriber.Subscriber;

public class PublisherTest {

    @Test
    void testPublisher() {
        Publisher publisher = new NewsPublisher();

        Subscriber subscriberOne = new NewsSubscriber("Subscriber 1");
        Subscriber subscriberTwo = new NewsSubscriber("Subscriber 2");
        Subscriber subscriberTree = new NewsSubscriber("Subscriber 3");

        publisher.subscribe(subscriberOne);
        publisher.subscribe(subscriberTwo);
        publisher.subscribe(subscriberTree);

        publisher.notifySubscribers("Hello, I am Angela!!!");

        publisher.unsubscribe(subscriberTwo);

        publisher.notifySubscribers("Hello, I am Volodymyr!!!");
    }
}
