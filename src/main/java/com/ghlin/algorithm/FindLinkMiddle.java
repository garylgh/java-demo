package com.ghlin.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * find middle element of LinkedList in one pass
 * https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html
 */
public class FindLinkMiddle {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(2, 3, 5, 6, 7, 1));
        int middle = list.get(0);
        int currLength = 0;
        for (Integer num : list) {
            currLength++;
            if (currLength % 2 == 0) {
//                middle =
            }
        }

    }
}
