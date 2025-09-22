package org.livecoding.service;

import org.junit.jupiter.api.Test;
import org.livecoding.component.MyBlockingQueue;

public class MyBlockingQueueTest {

    @Test
    void testMyBlockingQueue() throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int val = queue.take();
                    System.out.println("Consume: " + val);
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
