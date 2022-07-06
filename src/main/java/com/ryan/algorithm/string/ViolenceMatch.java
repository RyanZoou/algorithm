package com.ryan.algorithm.string;

/**
 * @author ryanzou
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "ryanzou,...ryanzou最靓！";
        String str2 = "ryanzou最靓";
        int index = violenceMatch(str1, str2);
        System.out.println("index==" + index);
    }

    /**
     * 暴力匹配
     *
     * @param str1
     * @param str2
     * @return
     */
    private static int violenceMatch(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int s1len = str1.length();
        int s2len = str2.length();
        int i = 0, j = 0;
        while (i < s1len && j < s2len) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2len) {
            return i - j;
        }
        return -1;
    }

}
