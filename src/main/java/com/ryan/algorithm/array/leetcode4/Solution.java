package com.ryan.algorithm.array.leetcode4;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @author ryanzou
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numSum = new int[nums1.length + nums2.length];
        int n1index = 0, n2index = 0, sumIndex = 0;
        while (n1index < nums1.length && n2index < nums2.length) {
            if (nums1[n1index] < nums2[n2index]) {
                numSum[sumIndex] = nums1[n1index];
                n1index++;
            } else {
                numSum[sumIndex] = nums2[n2index];
                n2index++;
            }
            sumIndex++;
        }
        if (n1index < nums1.length) {
            while (n1index < nums1.length) {
                numSum[sumIndex] = nums1[n1index];
                n1index++;
                sumIndex++;
            }
        }
        if (n2index < nums2.length) {
            while (n2index < nums2.length) {
                numSum[sumIndex] = nums2[n2index];
                n2index++;
                sumIndex++;
            }
        }
        int midSumIndex = (sumIndex - 1) / 2;
        if (sumIndex % 2 == 1) {
            return numSum[midSumIndex];
        } else {
            return (numSum[midSumIndex] + numSum[midSumIndex + 1]) / 2.00000D;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        double midVal = (new Solution()).findMedianSortedArrays(num1, num2);
        System.out.println(midVal);
    }
}
