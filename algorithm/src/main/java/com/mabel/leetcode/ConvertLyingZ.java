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

    /**
     * 该方法的关键在于如何通过字符串的长度和排列行数求得列数,
     * 目前还有问题，尚未能够通过所有用例
     * "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers."
     * 10
     * 预期输出："A,tsaclmapdpohttsmetaltennarhreiheerilosnodlorornahwioawutiw.iwa,suttadnrajstosnasrefcdyr,endtarrdseeqoaaiewncaouderi,buenenhieerptddoenmecbrettgsouciimuneihfnv"
     * 实际输出："A,tsaclmapdpohttsmetaltennarhreiheerilosnodlorornahwioawutiwi.wa,suttadnrajstonsasrefcdyr,endtardrseeqoaaiewncaoudrei,buenenhieerptddenmecbrettgsouciimuneihfnv"
     * */
    public static String convertV2(String s, int numRows) {
        if (numRows == 1 || numRows == s.length()) {
            return s;
        }
        // 通过行数量和字符串的长度求列数
        int more = s.length() % (numRows + numRows - 2);
        if (0 < more && more <= numRows) {
            more = 1;
        } else if (more > numRows) {
            more = 2;
        }
        int column = 0;
        if (s.length() < numRows) {
            column = 1;
        } else if (s.length() / (numRows + numRows - 2) == 0) {
            column = 1 + s.length() - numRows; // 注意列数的计算
        } else {
            column = s.length() / (numRows + numRows - 2) * (numRows - 1) + more; // 注意列数的计算
        }
        char[] chars = new char[numRows * column];
        int index = 0;
        int i = 0, j = 0;
        while (index < s.length()) {
            chars[i * column + j] = s.charAt(index);
            if (i < numRows) {
                if (j % (numRows - 1) == 0) {
                    i++;
                } else {
                    i--;
                    j++;
                }
            }
            if (numRows <= i) {
                i = i - 2;
                j++;
            }
            index++;
        }
        return String.valueOf(chars).replaceAll("\0", "");
    }

    public static void main(String[] args) {
        String input = "PINALSIGYAHRPI";
        System.out.println("(" + input + ", " + 3 + ")--> " + convert(input, 3));
        System.out.println("(" + input + ", " + 4 + ")--> " + convert(input, 4));
        System.out.println("(" + input + ", " + 5 + ")--> " + convert(input, 5));
        System.out.println("(" + input + ", " + 15 + ")--> " + convert(input, 15));

//        System.out.println("(" + input + ", " + 3 + ")--> " + convertV2(input, 3));
//        System.out.println("(" + input + ", " + 4 + ")--> " + convertV2(input, 4));
//        System.out.println("(" + input + ", " + 5 + ")--> " + convertV2(input, 5));
        System.out.println("(" + input + ", " + 15 + ")--> " + convertV2(input, 15));
    }
}
