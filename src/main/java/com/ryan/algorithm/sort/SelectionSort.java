package com.ryan.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    /**
     * 选择正序排序
     *
     * @param list 无序整形数组
     */
    public static void selectionSort(int[] list) {
        int length = list.length;
        for (int i = 0; i < length; i++) {
            int minValueIndex = i;
            for (int j = i; j < length; j++) {
                if (list[minValueIndex] > list[j]) {
                    minValueIndex = j;
                }
            }
            swap(list, i, minValueIndex);
        }
    }

    /**
     * 交换数组中两个索引的值
     *
     * @param list 数组
     */
    private static void swap(int[] list, int indexI, int indexJ) {
        try {
            int tempValue = list[indexI];
            list[indexI] = list[indexJ];
            list[indexJ] = tempValue;
        } catch (Exception e) {
            System.out.println("元素换位置失败：" + e.getMessage());
        }
    }

}
