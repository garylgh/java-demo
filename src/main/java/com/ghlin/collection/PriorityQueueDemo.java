package com.ghlin.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // ** 最小堆 **
        Queue<Integer> qi = new PriorityQueue();
        qi.add(5);
        qi.add(2);
        qi.add(1);
        qi.add(10);
        qi.add(3);

        while (!qi.isEmpty()) {
            System.out.print(qi.poll() + ",");
        }

        System.out.println("-----------------------------");

        // ** 最大堆 **
        Comparator cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };

        Queue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
        q2.add(2);
        q2.add(8);
        q2.add(9);
        q2.add(1);
        while (!q2.isEmpty()) {
            System.out.print(q2.poll() + ",");
        }
    }
}
