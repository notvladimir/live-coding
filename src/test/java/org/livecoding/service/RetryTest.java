package org.livecoding.service;

import org.junit.jupiter.api.Test;

import static org.livecoding.component.Retry.runWithRetry;

public class RetryTest {

    @Test
    void testRetry() {
        int result = runWithRetry(() -> {
            if(Math.random() < 0.7) {
                throw new RuntimeException("Random exception");
            }
            return 42;
        }, 5, 500);

        System.out.println("Success result: " + result);
    }
}
