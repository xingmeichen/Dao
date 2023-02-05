package com.dao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: Dao
 * @description: 无重复字符的最长子串
 * @author: Mabel.Chen
 * @create: 2019-10-20 10:59
 **/
public class LongestNoRepeatSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestNoRepeatSubstring longestSubstring = new LongestNoRepeatSubstring();
        int longestLength = longestSubstring.lengthOfLongestSubstring("davddf");
        System.out.println(longestLength);
    }
}