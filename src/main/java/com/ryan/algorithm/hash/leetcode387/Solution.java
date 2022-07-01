package com.ryan.algorithm.hash.leetcode387;

/**
 * 利用hash函数解题
 *
 * @author ryanzou
 */
public class Solution {

    /**
     *给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     *
     *
     * 示例 1：
     *
     * 输入: s = "leetcode"
     * 输出: 0
     * 示例 2:
     *
     * 输入: s = "loveleetcode"
     * 输出: 2
     * 示例 3:
     *
     * 输入: s = "aabb"
     * 输出: -1
     *
     * 提示:
     *
     * 1 <= s.length <= 105
     * s只包含小写字母
     *
     * @param s
     * @return int
     */
    public int firstUniqChar(String s) {
        int[] uniqueCharArr = new int[26];
        for (int i = 0; i < s.length(); i++) {

            // f(ch) = s.charAt(i) - 'a';
            uniqueCharArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            // f(ch) = s.charAt(i) - 'a';
            if (uniqueCharArr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
