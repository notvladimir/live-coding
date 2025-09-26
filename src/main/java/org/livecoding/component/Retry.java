package org.livecoding.component;

import java.util.function.Supplier;

public class Retry {

    public static <T> T runWithRetry(Supplier<T> action, int maxAttempts, long delayMs) {
        RuntimeException lastException = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                return action.get();
            } catch (RuntimeException e) {
                lastException = e;
                System.out.println("Attempt: " + attempt + " failed: " + e.getMessage());
                if (attempt < maxAttempts) {
                    try {
                        Thread.sleep(delayMs);
                    } catch (InterruptedException ignore) {
                        Thread.currentThread().interrupt();
                        throw e;
                    }
                }

            }
        }

        throw lastException;
    }
}
