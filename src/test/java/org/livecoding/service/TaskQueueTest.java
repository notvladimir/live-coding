package org.livecoding.service;

import org.junit.jupiter.api.Test;
import org.livecoding.component.TaskQueue;

import java.util.concurrent.Executors;

public class TaskQueueTest {

    private static final String POISON_PILL = "STOP";

    @Test
    void testTaskQueue() {
        var taskQueue = new TaskQueue();

        try (var pool = Executors.newFixedThreadPool(4)) {
            pool.submit(() -> {
                for (int i = 0; i < 20; i++) {
                    try {
                        taskQueue.produce("Task " + i);
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

                try {
                    taskQueue.produce(POISON_PILL);
                    taskQueue.produce(POISON_PILL);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });

            pool.submit(() -> {
                while(true) {
                    try {
                        System.out.print("consumer 1 ");
                        var task = taskQueue.consumed();
                        if (POISON_PILL.equals(task)) {
                            System.out.println("Stopped consumer 1");
                            break;
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });

            pool.submit(() -> {
                while(true) {
                    try {
                        System.out.print("consumer 2 ");
                        var task = taskQueue.consumed();
                        if (POISON_PILL.equals(task)) {
                            System.out.println("Stopped consumer 1");
                            break;
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
    }
}
