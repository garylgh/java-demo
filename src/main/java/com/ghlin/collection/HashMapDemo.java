package com.ghlin.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();

        // ** add null **
        map.put("key1", "v1");
        map.put("key2", "v2");
        map.put(null, "v3");
        map.put(null, "v4");

        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }

        for (Iterator<String> iter = map.values().iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }
}
