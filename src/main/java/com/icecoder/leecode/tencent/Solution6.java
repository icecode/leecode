package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/22 8:03 上午
 */
public class Solution6 {

    public static void main(String[] args) {
        new Solution6().reverseString("ab".toCharArray());
        new Solution6().reverseString("abc".toCharArray());
        new Solution6().reverseString("abcd".toCharArray());
        new Solution6().reverseString("abcde".toCharArray());
    }

    public void reverseString(char[] s) {
        char l, r;
        int sl = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            l = s[i];
            r = s[sl - i];
            s[i] = r;
            s[sl -i] = l;
        }
        System.out.println(s);
    }
}
