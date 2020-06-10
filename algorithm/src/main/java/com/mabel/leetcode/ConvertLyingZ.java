package com.mabel.leetcode;

/**
 * @project:
 * @description:
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 又如：
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * @author: Mabel.Chen
 * @create: 2020/6/9
 **/
public class ConvertLyingZ {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] chars = new char[s.length()][s.length()];
        int index = 0;
        int i = 0;
        int j = 0;
        while (index < s.length()) {
            chars[i][j] = s.charAt(index);
            if (i < numRows) {
                if (j % (numRows - 1) == 0) { // 注意这个边界条件
                    i++;
                } else {
                    i--;
                    j++;
                }
            }
            if (numRows <= i) { // 注意这个边界条件
                i = i - 2; // 注意这个值的重新赋值
                j++;
            }
            index++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char c = 0;
        for (i = 0; i < chars.length; i++) {
            for (j = 0; j < chars.length; j++) {
                if (chars[i][j] != c) {
                    stringBuilder.append(chars[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String input = "A";
        System.out.println("(" + input + ", " + 3 + ")--> " + convert(input, 3));
        System.out.println("(" + input + ", " + 4 + ")--> " + convert(input, 4));
        System.out.println("(" + input + ", " + 5 + ")--> " + convert(input, 5));
    }
}
