package org.livecoding.component.bublishersubscriber;

public class NewsSubscriber implements Subscriber {

    private final String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}
