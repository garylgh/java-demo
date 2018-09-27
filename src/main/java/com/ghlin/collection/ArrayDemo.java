package com.ghlin.collection;

import java.util.Arrays;

/**
 * 参考：https://blog.csdn.net/u014199097/article/details/50551731
 * http://javadevnotes.com/java-array-to-list-examples
 */
public class ArrayDemo {
    public static void normalArray() {
        // ** 声明数组，Java语言中声明数组时不能指定其长度（数组中元素的个数）**
        String[] strArr1;
        String strArr2[];
        // 错误声明，声明时不能指定数组大小
        // String strArr3[10];

        // ** 创建数组 **
        // 1. 使用关键字new创建数组对象，格式为：数组名 = new 数组元素的类型 [数组元素的个数]
        strArr1 = new String[10];
        strArr2 = new String[]{"abc", "def", "ghj"};

        for (String s : strArr1) {
            System.out.println(s);
        }

        for (int i = 0; i < strArr2.length; i++) {
            System.out.println(strArr2[i]);
        }

        // ** 初始化数组 **
        // 1. 静态初始化
        String[] iniArr1 = new String[]{"123", "567", "098"};
        System.out.println("iniArr1 length is: " + iniArr1.length);
        // 2. 静态初始化简化方式
        String[] iniArr2 = {"grape", "cantaloupe", "nectarine"};
        // 3. 动态初始化
        String[] iniArr3 = new String[3];
        // 错误写法：静态初始化不能指定元素个数
        //        String[] iniArr4 = new String[3] {"a", "b"};
        // 错误写法：动态初始化必须指定元素个数
        // String[] iniArr5 = new String[];

        // ** 插入数据 **
        //        iniArr1[3] = "insert1";
        //        for (String s : iniArr1) {
        //            System.out.println(s);
        //        }

        iniArr3[1] = "test1";
        for (String s : iniArr3) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        normalArray();


        int[] srcArr = {1, 2, 3, 4, 5, 6, 7};
        int[] destArr = new int[10];
        System.arraycopy(srcArr, 1, destArr, 2, 5);

        for (int i : destArr) {
            System.out.println("destArr[]: " + i);
        }
    }
}
