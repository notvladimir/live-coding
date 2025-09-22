package org.livecoding.service;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionService {

  public boolean isDuplicates(int[] arr) {
    var set = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));

    return arr.length != set.size();
  }

  public Map<String, Integer> countWords(String sentence) {
    var words = sentence.split("\\W+");
    Map<String, Integer> res = new HashMap<>();
    for (var word : words) {
      var w = word.toLowerCase();
      res.put(w, res.getOrDefault(w, 0) + 1);
    }
    return res;
  }

  public Map<String, Integer> countWordsStreams(String sentence) {
    return Arrays.stream(sentence.split("\\W+"))
            .map(String::toLowerCase)
            .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
  }

  public String[] topWords(String[] words, int k) {
    return Arrays.stream(words)
            .map(String::toLowerCase)
            .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum))
            .entrySet().stream()
            .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
            .limit(k)
            .map(Map.Entry::getKey)
            .toArray(String[]::new);
  }
}
