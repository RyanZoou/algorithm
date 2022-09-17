package com.ryan.algorithm.array.leetcode6;

import java.util.ArrayList;

/**
 * Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class Solution {

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows <= 1) {
            return s;
        }

        ArrayList<char[]> chars = new ArrayList<>();
        int counter = 0;
        boolean isFullRound = true;
        char[] currentChars = new char[numRows];
        for (int i = 0; i < s.length(); i++) {
            if (isFullRound || numRows == 2) {
                currentChars[counter] = s.charAt(i);
                counter ++;
                if (counter == numRows || i == s.length() -1) {
                    isFullRound = false;
                    chars.add(currentChars);
                    currentChars = new char[numRows];
                    counter = 0;
                }
            } else {
                counter++;
                int colPos = numRows - counter - 1;
                currentChars[colPos] = s.charAt(i);
                chars.add(currentChars);
                currentChars = new char[numRows];
                if (counter == numRows - 2) {
                    isFullRound = true;
                    counter = 0;
                }
            }
        }
        printChars(chars);
        StringBuilder outLine = new StringBuilder();
        for (int i=0; i < numRows; i++) {
            for (int j=0; j < chars.size(); j++) {
                char cur = chars.get(j)[i];
                if ('\u0000' != cur) {
                    outLine.append(cur);
                }
            }
        }
        return outLine.toString();
    }

    public static void printChars(ArrayList<char[]> chars) {
        for (char[] charArr : chars) {
            StringBuilder outLine = new StringBuilder();
            for (char c : charArr) {
                outLine.append("\t").append(c);
            }
            String str = outLine.toString();
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        String res = convert("PAYPALISHIRING", 3);
        System.out.println(res);
    }

    /**
     * 正解如下
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convertRight(String s, int numRows) {
        // 如果只有一行，直接返回即可
        if (numRows == 1)
            return s;
        // 每行的字符串
        StringBuilder[] stringLine = new StringBuilder[numRows];
        for (int i = 0; i < stringLine.length; i++) {
            stringLine[i] = new StringBuilder();
        }

        // 1表示往下走，-1表示往上走
        int increase = 1;
        int line = 0;// 第几行
        for (int i = 0; i < s.length(); i++) {
            stringLine[line].append(s.charAt(i));
            // 如果当前是在第一行，下一步就应该往下走
            if (line == 0)
                increase = 1;
            // 如果当前是在最后一行，下一步应该往上走
            if (line == numRows - 1)
                increase = -1;
            // 下一步应该到第几行
            line += increase;
        }

        // 把上面的几行合并成一个字符串
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stringLine.length; i++) {
            res.append(stringLine[i]);
        }
        return res.toString();
    }

}
