package com.ryan.algorithm.string;

import java.util.Arrays;

/**
 * @author ryanzou
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABDE ";
        String str2 = "ABCDABD";
        int[] next = keyNext(str2);
        System.out.println("next::" + Arrays.toString(next));
        int index = kemMatch(str1, str2, next);
        System.out.println("index==" + index);
    }

    private static int kemMatch(String str1, String str2, int[] next) {
        for (int i = 1, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int[] keyNext(String str2) {
        int strLen = str2.length();
        int[] next = new int[strLen];
        next[0] = 0;
        for (int i = 1, j = 0; i < strLen; i++) {
            while (j > 0 && str2.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str2.charAt(i) == str2.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
