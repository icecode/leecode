package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/6/25 10:30 上午
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println("prefix:" + l.longestCommonPrefix(new String[]{}));
        System.out.println("prefix:" + l.longestCommonPrefix(new String[]{"abc"}));
        System.out.println("prefix:" + l.longestCommonPrefix(new String[]{"a", "ab", "abc"}));
        System.out.println("prefix:" + l.longestCommonPrefix(new String[]{"a", "ba", "abc"}));
        System.out.println("prefix:" + l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("prefix:" + l.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println("prefix:" + l.longestCommonPrefix(new String[]{"","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (minLength > s.length()) {
                minLength = s.length();
            }
        }
        if (minLength == 0) {
            return "";
        }
        int index = 0;
        char testChar;
        topLoop:
        while ( index < minLength) {
            testChar =  strs[0].charAt(index);
            for (String s : strs) {
                if (s.charAt(index) != testChar) {
                    break topLoop;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }
}
