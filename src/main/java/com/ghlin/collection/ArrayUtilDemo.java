package com.ghlin.collection;

import java.util.*;

public class ArrayUtilDemo {
    public static void main(String[] args) {
        // ** asList from int **
        List<Integer> intArr = Arrays.asList(1, 2, 3, 4, 5);
        ListIterator<Integer> iiter = intArr.listIterator();
        while (iiter.hasNext()) {
            System.out.println(iiter.next());
        }

        // ** asList from array **
        Integer[] spam = new Integer[] { 9, 8, 7 };
        List<Integer> list2 = Arrays.asList(spam);
        Iterator<Integer> spanIter = list2.iterator();
        while (spanIter.hasNext()) {
            Integer currVal = spanIter.next();
            System.out.println("currVal: " + currVal);
        }

        // ** iterator remove **
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        System.out.println("Before iterate list1 : " + list1);
        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            String t = it.next();
            if ("bbb".equals(t)) {
                it.remove();
            }
        }
        System.out.println("After iterate list1 : " + list1);

        // ** iterator remove2 **
        // 通过Arrays.asList创建的list，在迭代器中执行remove是无效的。。。
        //        List<String> list3 = Arrays.asList(new String[]{"aaa", "bbb", "ccc"});
        //        System.out.println("Before iterate list3 : " + list3);
        //        Iterator<String> iter3 = list3.iterator();
        //        while (iter3.hasNext()) {
        //            String t = iter3.next();
        //            if ("bbb".equals(t)) {
        //                iter3.remove();
        //            }
        //        }
        //        System.out.println("After iterate list3 : " + list3);

        // ** iterator remove3 **
        ArrayList<String> list4 = new ArrayList<String>();
        list4.add("aaa");
        list4.add("bbb");
        list4.add("ccc");
        System.out.println("Before iterate list4 : " + list4);
        for (Iterator<String> iter4 = list4.iterator(); iter4.hasNext();) {
            String aval = iter4.next();
            if ("bbb".equals(aval)) {
                iter4.remove();
            }
        }
        System.out.println("After iterate list4 : " + list4);

        // ** binarySearch **
        int searchIdx1 = Arrays.binarySearch(new Integer[]{1, 5, 2, 8, 29, 11}, 11);
        System.out.println("searchIdx1 = " + searchIdx1);


        // ** fill **
        int[] need2FillArr = new int[10];
        Arrays.fill(need2FillArr, 5, 8, 6);
        for (int a : need2FillArr) {
            System.out.println("a = " + a);
        }

        // ** copyOf **
        int[] beCopiedArr = new int[]{5, 7, 2, 8};
        int[] newArr = Arrays.copyOf(beCopiedArr, 8);
        for (int a : newArr) {
            System.out.println("copyOf a = " + a);
        }
    }
}
