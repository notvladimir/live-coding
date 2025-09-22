package org.livecoding.component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskQueue {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void produce(String task) throws InterruptedException {
        queue.put(task);
        System.out.println("Produces: " + task);
    }

    public String consumed() throws InterruptedException {
        String task = queue.take();

        System.out.println("Consumes: " + task);

        return task;
    }

}
