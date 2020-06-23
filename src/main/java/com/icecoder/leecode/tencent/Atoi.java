package com.icecoder.leecode.tencent;

import java.util.Stack;

/**
 * @author libing
 * @version 1.0
 * @date 2020/6/23 6:44 上午
 */
public class Atoi {


    public static void main(String[] args) {
        Atoi a = new Atoi();
        System.out.println(a.atoi("42"));
        System.out.println(a.atoi("+1"));
        System.out.println(a.atoi("   -42"));
        System.out.println(a.atoi("words and 987"));
        System.out.println(a.atoi("-91283472332"));
        System.out.println(a.atoi("  0000000000012345678"));
        System.out.println(a.atoi("  +923456789"));
        System.out.println(a.atoi("-000000000000001"));
        System.out.println(a.atoi("0-1"));
    }


    public int atoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int readIndex = 0;
        int valMark = 1;
        char c = ' ';
        Stack<Character> numberChar = new Stack<>();
        while (readIndex < str.length()) {
            c = str.charAt(readIndex++);
            if (c == ' ') {
                continue;
            }
            if (c == '-') {
                valMark = -1;
                break;
            }
            if (c == '+') {
                break;
            }
            if (isNumber(c)) {
                readIndex--;
                break;
            } else {
                return 0;
            }
        }

        while (readIndex < str.length()) {
            c = str.charAt(readIndex++);
            if (numberChar.isEmpty() && c == '0') {
                continue;
            }
            if (isNumber(c)) {
                numberChar.push(c);
                if (numberChar.size() > 10) {
                    return valMark == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        long parseVal = 0;
        long ratio = 1;
        while (!numberChar.isEmpty()) {
            char cc = numberChar.pop();
            parseVal += number(cc) * ratio;
            ratio *= 10;
        }
        parseVal *= valMark;
        return (parseVal > Integer.MAX_VALUE ? Integer.MAX_VALUE : (parseVal < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)parseVal));
    }

    public boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public int number(char c) {
        return (int)c - 48;
    }
}
