package com.ryan.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    @Test
    public void selectionSortTest() {
        int[] sortedList = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        };
        int[] unSortList = new int[]{
                2, 7, 8, 9, 10, 0, 1, 12, 16, 17, 19, 20, 3, 4, 5, 6, 15, 13, 14, 18, 11
        };
        SelectionSort.selectionSort(unSortList);
        System.out.println(Arrays.toString(unSortList));
        assertArrayEquals(sortedList, unSortList);
    }

}
