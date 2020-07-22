package com.icecoder.leecode.tencent;

import java.util.Stack;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/22 8:13 上午
 */
public class Solution7 {

    public static void main(String[] args) {
        System.out.println("v:" + new Solution7().reverseWords("ab ac ad"));
        System.out.println("v:" + new Solution7().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> tc = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                while (!tc.isEmpty()) {
                    sb.append(tc.pop());
                }
                sb.append(c);
            } else {
                tc.push(c);
            }
        }
        while (!tc.isEmpty()) {
            sb.append(tc.pop());
        }
        return sb.toString();
    }
}
