package com.ghlin.algorithm;

import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{4, 6, 2, 6, 5, 8, 9, 3, 3, 2};
        List<Integer> al = new ArrayList<Integer>(Arrays.<Integer>asList(numbers));

        HashSet<Integer> ls = new HashSet<>(al);
        Iterator<Integer> iter = ls.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
