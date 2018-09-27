package com.ghlin.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
//    private ArrayList<String> container;
//    public void createArrayList() {
//        container = new ArrayList<>(10);
//    }

    public static void main(String[] args) {
        List<String> container = new ArrayList(10);

        // ** add **
        container.add("abc");
        container.add("def");
        container.add(1, "index1");
        container.add(0, "index10");
        System.out.println("after add: " + container);

        // ** remove **
        container.add(1, "needRemove");
        System.out.println("before remove: " + container);
        container.remove("def");
        container.remove("sdfasdfadf");
        System.out.println("after remove: " + container);

        // ** indexOf **
        System.out.println("indexOf index1: " + container.indexOf("index1"));

        // ** retain **
        container.retainAll(Arrays.asList("index1", "abc"));
        System.out.println("after retain: " + container);

        // ** hashCode **
        int hashCode = container.hashCode();
        System.out.println("hashCode = " + hashCode);

        // ** add null **
        container.add(1, null);
        System.out.println("after add null: " + container);

        // ** trimToSize **
        container.set(1, "haha");
        System.out.println("after set: " + container);

        container.isEmpty();

    }
}
