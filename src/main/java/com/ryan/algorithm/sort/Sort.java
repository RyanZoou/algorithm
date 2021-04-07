package com.ryan.algorithm.sort;

public abstract class Sort {

    /**
     * 交换数组中两个索引的值
     *
     * @param list 数组
     */
    public static void swap(int[] list, int indexI, int indexJ) {
        try {
            int tempValue = list[indexI];
            list[indexI] = list[indexJ];
            list[indexJ] = tempValue;
        } catch (Exception e) {
            System.out.println("元素换位置失败：" + e.getMessage());
        }
    }

}
