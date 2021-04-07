package com.ryan.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort extends Sort {

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

}
