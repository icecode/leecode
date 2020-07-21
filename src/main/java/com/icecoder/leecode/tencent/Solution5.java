package com.icecoder.leecode.tencent;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/21 8:24 下午
 */
public class Solution5 {

    public static void main(String[] args) {
        System.out.println("v:" + new Solution5().isValid("()"));
        System.out.println("v:" + new Solution5().isValid("()[]{}"));
        System.out.println("v:" + new Solution5().isValid("(]"));
        System.out.println("v:" + new Solution5().isValid("([)]"));
        System.out.println("v:" + new Solution5().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> t = new Stack<>();
        t.push(' ');
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    t.push(c);
                    break;
                case '}':
                    if (t.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (t.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (t.pop() != '(') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return t.size() <= 1;
    }
}
