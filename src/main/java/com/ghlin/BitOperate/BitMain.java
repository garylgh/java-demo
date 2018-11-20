package com.ghlin.BitOperate;

public class BitMain {
    public static void main(String[] args) {
        moveBit();

        setBit(2, 4);

        bitArray(40);

        System.out.println("-------------------------");
        // 获取整数最大值
        System.out.println((1 << 31) - 1);
        // 2. 获得int型最小值
        System.out.println(1 << 31);
    }

    public static void moveBit() {
        System.out.println("---------------------位移操作");
        int a = -15;
        int b = 2;
        int c = 5;

        // 右移操作：各二进位全部右移若干位，对无符号数，高位补 0，有符号数，各编译器处理方法不一样，有的补符号位(算术右移)，有的补 0 (逻辑右移)
        // -15 = [1111 0001]补，右移二位，最高位由符号位填充将得到 [1111 1100]补 即 -4
        printBinary(a >> 2);
        // 左移操作：各二进位全部左移若干位，高位丢弃，低位补 0
        // 15= [0000 1111]补，右移二位，最高位由符号位填充将得到 [0000 0011] 即 3
        printBinary(b << 2);
        // &操作：两个位都为 1 时，结果才为 1
        printBinary(c & 1);
        // 1移位32位：移位是循环的
        printBinary(1 << 32);
    }

    // 判断奇数：只要根据最未位是 0 还是 1 来决定，为 0 就是偶数，为 1 就是奇数
    public static boolean isOdd(int num) {
        System.out.println("---------------------判断奇偶数");
        System.out.println(1 & num);
        return (1 & num) == 0;
    }

    public static void printBinary(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    // 在一个数指定位上置1
    // 如何对一个整数在指定位置上置1? 对于一个整数可以通过将 1 向左移位后与其相或来达到在指定位上置1的效果
    public static int setBit(int num, int pos) {
        System.out.println("before setBit " + pos + ", num =" + num);
        num |= (1 << pos);
        System.out.println("after setBit " + pos + ", num =" + num);
        return num;
    }

    //判断指定位上是0还是1
    public static int checkBit(int num, int pos) {
        return num & (1 << pos);
    }

    // 每隔3位设置1
    public static void bitArray(int bitCount) {
        int[] bitArr = new int[bitCount / 32 + 1];
        for (int i = 0; i < bitCount; i += 3) {
            bitArr[i / 32] |= (1 << (i % 32));
        }

        for (int i = 0; i < bitCount; i++) {
            if (((bitArr[i / 32] >> (i % 32)) & 1) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
    }

}
