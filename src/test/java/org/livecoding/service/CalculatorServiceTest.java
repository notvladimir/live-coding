package org.livecoding.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

  @Test
  void testStaticAdd() {
    var result = CalculatorService.sum(5, 6);
    assertEquals(11, result);
  }

  @Test
  void testAdd() {
    var sut = new CalculatorService(2, 5);
    assertEquals(7, sut.sum());
  }

  @Test
  void safeDivide() {
    var sut = new CalculatorService();

    assertEquals(2, sut.safeDivide(10, 5));
    assertEquals(-1, sut.safeDivide(10, 0));
  }
}
