package org.livecoding.service;

import org.junit.jupiter.api.Test;
import org.livecoding.component.RateLimiter;

public class RateLimiterTest {

  @Test
  void testRateLimiter() throws InterruptedException {
    var sut = new RateLimiter(5, 1000);

    for (int i = 0; i < 10; i++) {
      if (sut.tryAcquire()) {
        System.out.println("✅ Request allowed: " + i);
      } else {
        System.out.println("❌ Request denied: " + i);
      }
      Thread.sleep(150);
    }
  }
}
