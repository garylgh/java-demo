package com.ghlin.collection;

import java.util.Iterator;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;
    private Map<K, V> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.LinkedHashMap<K, V> (capacity, 0.75f, true) {
            // 定义put后的移除规则，大于容量就删除eldest
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }
    public V get(K key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else
            return null;
    }
    public void set(K key, V value) {
        cache.put(key, value);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.cache.entrySet().iterator();
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache(3);
        cache.set(1, 11);
        cache.set(2, 22);
        cache.set(3, 33);

        for (Iterator<Map.Entry<Integer, Integer>> iter = cache.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }

        System.out.println("-------------------------");

        cache.get(2);
        cache.get(2);
        cache.get(3);
        cache.get(1);
        cache.get(1);
        cache.set(4, 44);

        for (Iterator<Map.Entry<Integer, Integer>> iter = cache.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }
}
