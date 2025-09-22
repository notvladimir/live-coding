package org.livecoding.component;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache<K, V> {

  private final Map<K, CacheItem<V>> cache = new ConcurrentHashMap<>();
  private final long ttlSeconds;

  public SimpleCache(long ttlSeconds) {
    this.ttlSeconds = ttlSeconds;
  }

  public void put(K key, V value) {
    this.cache.put(key, new CacheItem<>(value));
  }

  public V get(K key) {
    var item = cache.get(key);
    if (item == null) return null;

    if (item.isExpired(this.ttlSeconds)) {
      cache.remove(key);
      return null;
    }

    return item.value;
  }

  private static class CacheItem<V> {
    final V value;
    final Instant createdAt;

    public CacheItem(V value) {
      this.value = value;
      this.createdAt = Instant.now();
    }

    boolean isExpired(long ttlSeconds) {
      return Instant.now().isAfter(createdAt.plusSeconds(ttlSeconds));
    }
  }
}
