package com.ryan.algorithm.divided;

/**
 * 汉诺塔问题求解
 *
 * @author ryanzou
 */
public class Hanoitower {

    public static void hanoitower(int nums, char a, char b, char c) {
        if (nums < 2) {
            System.out.printf("第%d个盘子%c -> %c\n", nums, a, c);
        } else {
            hanoitower(nums - 1, a, c, b);
            System.out.printf("第%d个盘子%c -> %c\n", nums, a, c);
            hanoitower(nums - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        hanoitower(3, 'A', 'B', 'C');
    }
}
