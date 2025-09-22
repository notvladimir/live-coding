package org.livecoding.component.bublishersubscriber;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NewsPublisher implements Publisher {

    private final List<Subscriber> subscribers = new CopyOnWriteArrayList<>();

    @Override
    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void notifySubscribers(String message) {
        subscribers.forEach(s -> s.update(message));
    }
}
