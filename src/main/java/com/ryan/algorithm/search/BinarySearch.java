package com.ryan.algorithm.search;

public class BinarySearch {

    public static Integer binarySearch(int[] searchArray, int target) {
        int length = searchArray.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = searchArray[mid];

            System.out.println("index：" + mid + "，value：" + midVal);

            if (midVal == target) {
                return mid;
            } else if (target < midVal) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

}
