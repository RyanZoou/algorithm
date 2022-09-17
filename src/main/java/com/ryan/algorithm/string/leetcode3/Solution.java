package com.ryan.algorithm.string.leetcode3;

import java.util.HashMap;

/**
 * 给定一个字符串 s，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * @author ryanzou
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), 1);
            int j = i + 1;
            while (j < sLen) {
                char cur = s.charAt(j);
                if (!map.containsKey(cur)) {
                    j++;
                    map.put(cur, 1);
                } else {
                    break;
                }
            }
            max = Math.max(max, map.size());
        }
        return max;
    }


    /**
     * 优化解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int sLen = s.length();
        if (s.length() <= 1) {
            return sLen;
        }
        int max = 0, left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (left <= right && right < sLen) {
            char cur = s.charAt(right);

            // 如果在指针区间内找到了右指针指向的元素，则将左指针移动到重复元素的后一位
            if (map.containsKey(cur) && map.get(cur) >= left) {
                left = map.get(cur) + 1;
            }
            map.put(cur, right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }


    public static void main(String[] args) {
        String s1 = "abcabcbb";
        int max = (new Solution()).lengthOfLongestSubstring2(s1);
        System.out.println(max);
    }

}
