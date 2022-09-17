package com.ryan.algorithm.string.leetcode5;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * @author ryanzou
 */
public class Solution {

    /**
     * 中心扩散法获取最长回文子串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        String maxSubStr = "";
        for (int i = 0; i < chars.length - 1; i++) {
            int singleRes = maxSingleAroundLength(chars, i);
            int doubleRes = maxDoubleAroundLength(chars, i);
            if (singleRes > max) {
                max = singleRes;
                int sameLength = (singleRes - 1) / 2;
                maxSubStr = s.substring(i - sameLength, i + sameLength + 1);
            }
            if (doubleRes > max) {
                max = doubleRes;
                int sameLength = doubleRes / 2;
                maxSubStr = s.substring(i - sameLength + 1, i + sameLength + 1);
            }
        }
        return maxSubStr;
    }

    /**
     * 当前位置单个字符中心扩散
     *
     * @param chars
     * @param i
     * @return
     */
    public static int maxSingleAroundLength(char[] chars, int i) {
        int left = i, right = i;
        while (left >= 0 && right < chars.length) {
            if (chars[left] != chars[right]) {
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 当前位置及其下一个位置两个个字符中心扩散
     *
     * @param chars
     * @param i
     * @return
     */
    public static int maxDoubleAroundLength(char[] chars, int i) {
        int left = i, right = i + 1;
        while (left >= 0 && right < chars.length) {
            if (chars[left] != chars[right]) {
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String subStr = longestPalindrome("ac");
        System.out.println(subStr);
    }
}
