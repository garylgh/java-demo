package com.ghlin.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        // ** getFirst **
        System.out.println(list.getFirst());

        // ** getLast **
        String last = list.getLast();
        System.out.println(last);

        list.removeLast();
        System.out.println(list);
    }
}
