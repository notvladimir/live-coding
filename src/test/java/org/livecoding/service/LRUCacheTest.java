package org.livecoding.service;

import org.junit.jupiter.api.Test;
import org.livecoding.component.LRUCache;

public class LRUCacheTest {

    @Test
    void testLRUCache() {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1);
        cache.put(4, "D");


        System.out.println(cache.get(2)); // null
        System.out.println(cache.get(1)); // A
        System.out.println(cache.get(3)); // C
        System.out.println(cache.get(4)); // D
    }
}
