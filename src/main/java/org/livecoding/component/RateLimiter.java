package org.livecoding.component;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {

  private final int maxRequests;
  private final long windowMillis;

  private long windowStart;
  public final AtomicInteger counter = new AtomicInteger(0);

  public RateLimiter(int maxRequests, long windowMillis) {
    this.maxRequests = maxRequests;
    this.windowMillis = windowMillis;
    this.windowStart = System.currentTimeMillis();
  }

  public synchronized boolean tryAcquire() {
    long now = System.currentTimeMillis();

    if (now - windowStart >= windowMillis) {
      windowStart = now;
      counter.set(0);
    }

    if (counter.get() < maxRequests) {
      counter.incrementAndGet();
      return true;
    }

    return false;
  }
}
