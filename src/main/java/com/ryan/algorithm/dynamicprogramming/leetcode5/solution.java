package com.ryan.algorithm.dynamicprogramming.leetcode5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ryanzou
 */
public class solution {

    public String longestPalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (charMap.containsKey(cur)) {
                int left = charMap.get(cur);
                int right = i;
                while (left <= right) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        right--;
                    } else {
                        break;
                    }
                }
                if (right < left) {
                    max = Math.max(i - charMap.get(cur), max);
                }
            }
            charMap.put(cur, i);
        }

        return "";
    }
}
