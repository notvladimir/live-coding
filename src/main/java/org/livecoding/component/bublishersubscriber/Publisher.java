package org.livecoding.component.bublishersubscriber;

public interface Publisher {
    void subscribe(Subscriber s);
    void unsubscribe(Subscriber s);
    void notifySubscribers(String message);
}
