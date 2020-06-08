package com.mabel.leetcode;

/**
 * @project:
 * @description: 求最长回文子串
 * @author: Mabel.Chen
 * @create: 2020/6/5
 **/
public class LongestPalindromeSubString {

    /**
     * 中心扩展法求回文子串
     * */
    public static String longestPalindrome(String inputString) {
        if (null == inputString || inputString.length() <= 1) {
            return inputString;
        }
        int length = inputString.length();
        int maxStart = 0;
        int maxLength = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length - 1; i++) {
            int oddLength = expand(inputString, i, i);
            int evenLength = expand(inputString, i, i + 1);
            maxLength = Math.max(oddLength, evenLength);
            if (end - start < maxLength) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return inputString.substring(start, end + 1);
    }

    /**
     * 中心扩展法求回文子串-扩展
     * */
    public static int expand(String inputString, int left, int right) {
        int length = inputString.length();
        while (0 <= left && right < length) {
            if (inputString.charAt(left) == inputString.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String inputString = "aaaaaaaaaaaaaaaaabbaaaaaaaaaaaaa";
        String result = longestPalindrome(inputString);
        System.out.println(result);
    }
}
