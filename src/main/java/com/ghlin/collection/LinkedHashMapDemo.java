package com.ghlin.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    /** 一个固定大小的FIFO替换策略的缓存 */
    static class FIFOCache<K, V> extends LinkedHashMap<K, V>{
        private final int cacheSize;
        public FIFOCache(int cacheSize){
            this.cacheSize = cacheSize;
        }

        // 当Entry个数超过cacheSize时，删除最老的Entry
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > cacheSize;
        }
    }

    public static void main(String[] args) {
        //        HashMap<String, String> map = new HashMap<>();
        //        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //        for (int i = 0; i < 10; i++)     {
        //            map.put("key" + i, "val"+i);
        //        }
        //
        //        System.out.println(map);

        FIFOCache<String, String> fifoCache = new FIFOCache<>(5);
        for (int i = 0; i < 5; i++) {
            fifoCache.put("key" + i, "val"+i);
        }
        System.out.println("before single add: " + fifoCache);
        fifoCache.put("s1", "s1");
        System.out.println("after s1 add: " + fifoCache);
        fifoCache.put("s2", "s2");
        System.out.println("after s2 add: " + fifoCache);
    }
}
