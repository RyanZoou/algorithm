package com.ryan.algorithm.sort;

public class QuicklySort extends Sort {

    public static void quicklySort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        // 定义最左边的元素作为基准值
        int index = start + 1;
        for (int i = index; i <= end; i++) {
            if (arr[i] < arr[start]) {
                swap(arr, index, i);
                index ++;
            }
        }

        // 将基准值插入到分组中间
        int pivot = index - 1;
        swap(arr, start, pivot);

        // 快排比基准值小的部分
        quicklySort(arr, start, pivot - 1);

        // 快拍比基准值大的部分
        quicklySort(arr, pivot + 1, end);
    }

}
