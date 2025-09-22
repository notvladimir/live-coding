package org.livecoding.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadCsvServiceTest {

  @Test
  void testReadCsv() {
    var sut = new ReadCsvService();

    var users = sut.readCsv();

    Assertions.assertEquals(2, users.size());
  }
}
