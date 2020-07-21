package com.icecoder.leecode.tencent;

import java.util.Arrays;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/21 8:04 上午
 */
public class Solution4 {

    public static void main(String[] args) {
        System.out.println("v:" + multiply("5", "408"));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        /*
         *      1 2 3
         *      4 5 6
         *    -------
         *      7 3 8
         *    6 1 5
         *  4 9 2
         * ----------
         *  5 6 0 8 8
         */
        int maxLen = Math.max(num1.length(), num2.length());
        int[] digit1 = new int[num1.length()];
        for (int i = 1; i <= num1.length(); i++) {
            digit1[num1.length() - i] = num1.charAt(num1.length() - i) - 48;
        }
        int[] digit2 = new int[num2.length()];
        for (int i = 1; i <= num2.length(); i++) {
            digit2[num2.length() - i] = num2.charAt(num2.length() - i) - 48;
        }

        int[][] ret = new int[maxLen][maxLen * 2];
        for (int i = 0; i < digit2.length; i++) {
            Arrays.fill(ret[i], 0);
            int jv = 0;
            for (int j = 0; j < digit1.length; j++) {
                int v = digit2[digit2.length - i - 1] * digit1[digit1.length - j - 1];
                ret[i][i + j] = v % 10 + jv;
                jv = v / 10;
            }
            ret[i][i + digit1.length] = jv;
        }
        StringBuilder sb = new StringBuilder();
        int iv = 0;
        for (int i = 0; i < ret[0].length; i++) {
            int v = iv;
            for (int j = 0; j < ret.length; j++) {
                v += ret[j][i];
            }
            sb.append(v % 10);
            iv = v / 10;
        }
        StringBuilder realVal = new StringBuilder();
        for (int i = 1; i <= sb.length(); i++) {
            char c = sb.charAt(sb.length() - i);
            if (c == '0' && realVal.length() == 0) {
                continue;
            }
            realVal.append(sb.charAt(sb.length() - i));
        }
        return realVal.toString();
    }
}
