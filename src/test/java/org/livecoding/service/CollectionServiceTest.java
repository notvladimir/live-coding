package org.livecoding.service;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionServiceTest {

  @Test
  void testCountWords() {
    var sut = new CollectionService();
    var resI = sut.countWords("Hello world hello");
    assertEquals(Map.of("hello", 2, "world", 1), resI);

    var resII = sut.countWords("Java is great, Java is powerful!");
    assertEquals(Map.of("java", 2, "is", 2, "great", 1, "powerful", 1), resII);
  }

  @Test
  void testCountWordsStreams() {
    var sut = new CollectionService();
    var resI = sut.countWordsStreams("Hello world hello");
    assertEquals(Map.of("hello", 2, "world", 1), resI);

    var resII = sut.countWordsStreams("Java is great, Java is powerful!");
    assertEquals(Map.of("java", 2, "is", 2, "great", 1, "powerful", 1), resII);
  }

  @Test
  void testTopWords() {
    var sut = new CollectionService();
    String[] arrayI = { "java", "is", "java", "great", "is", "java" };
    String[] resultI = {"java", "is"};
    assertArrayEquals(resultI, sut.topWords(arrayI, 2));

    String[] arrayII = { "a", "b", "b", "c", "c" };
    String[] resultII = {"b", "c"};
    assertArrayEquals(resultII, sut.topWords(arrayII, 2));
  }
}
