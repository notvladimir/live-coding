package org.livecoding.service;

public class CalculatorService {

  private final int a;
  private final int b;

  public CalculatorService() {
    this.a = 0;
    this.b = 0;
  }

  public CalculatorService(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int sum() {
    return a + b;
  }

  public int minus() {
    return a - b;
  }

  public static int sum(int a, int b) {
    return a + b;
  }

  public int safeDivide(int a, int b) {
    try {
      return a / b;
    } catch (ArithmeticException ignored) {
      return -1;
    } finally {
      System.out.println("Вызов метода завершён");
    }
  }
}
