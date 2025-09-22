package org.livecoding.service;

import org.junit.jupiter.api.Test;
import org.livecoding.component.Logger;

public class LoggerTest {

  @Test
  void testLogger() {
    var logger = new Logger(Logger.Level.WARN);

    logger.info("This is info");   // не выведется
    logger.warn("This is warning"); // выведется
    logger.error("This is error");  // выведется
  }
}
