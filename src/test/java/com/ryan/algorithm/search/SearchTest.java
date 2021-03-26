package com.ryan.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    @Test
    public void binarySearchTest() {
        int[] searchList = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        };
        Integer targetIndex = BinarySearch.binarySearch(searchList, 19);
        if (targetIndex != null) {
            assertEquals(19, targetIndex.intValue());
        } else {
            System.out.println("not find!");
        }
    }

}
