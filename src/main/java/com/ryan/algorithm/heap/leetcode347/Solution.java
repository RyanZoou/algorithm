package com.ryan.algorithm.heap.leetcode347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ryanzou
 */
public class Solution {

    private class Node implements Comparable<Node> {

        private int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        // 注意需要使用小顶堆
        @Override
        public int compareTo(Node node) {
            return this.count - node.count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            if (numsMap.containsKey(num)) {
                numsMap.put(num, numsMap.get(num) + 1);
            } else {
                numsMap.put(num, 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int num : numsMap.keySet()) {
            int count = numsMap.get(num);
            Node pqPeek = pq.peek();
            if (pq.size() < k) {
                pq.add(new Node(num, count));
            } else if (count > pqPeek.count) {
                pq.poll();
                pq.add(new Node(num,count));
            }
        }

        int[] ret = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            ret[index++] = pq.poll().num;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        int[] topNums = (new Solution()).topKFrequent(nums, 2);
        System.out.println(Arrays.toString(topNums));
    }
}
