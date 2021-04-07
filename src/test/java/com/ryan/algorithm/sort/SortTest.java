package com.ryan.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


public class SortTest {

    /**
     * 选择排序测试
     */
    @Test
    public void selectionSortTest() {
        int[] unSortList = getRandomIntArr(10000);

        Long startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(unSortList);
        Long endTime = System.currentTimeMillis();
        System.out.println("exec time:" + (endTime - startTime));

        System.out.println(Arrays.toString(unSortList));
    }


    /**
     * 快排测试
     */
    @Test
    public void quicklySortTest() {
        int[] unSortList = getRandomIntArr(10000);

        Long startTime = System.currentTimeMillis();
        QuicklySort.quicklySort(unSortList, 0, unSortList.length - 1);
        Long endTime = System.currentTimeMillis();
        System.out.println("exec time:" + (endTime - startTime));

        System.out.println(Arrays.toString(unSortList));
    }


    /**
     * 获取一个指定长度的随机整形数组
     *
     * @param arrayLength 数组长度
     * @return 整形数组
     */
    public static int[] getRandomIntArr(int arrayLength) {
        Random rd = new Random();
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

}
