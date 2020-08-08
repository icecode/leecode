package com.icecoder.leecode.tencent;

import java.util.Stack;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/8 10:18 上午
 */
public class Solution22 {

    public static void main(String[] args) {
        System.out.println("ret:" + new Solution22().reverse(2147483647));
    }

    public int reverse(int x) {
        int xv = x < 0 ? -x : x;
        int ret = 0;
        int tmp;
        while (xv > 0) {
            tmp = ret * 10 + xv % 10;
            System.out.println("t:" + tmp);
            if (tmp / 10 != ret) {
                return 0;
            }
            ret = tmp;
            xv /= 10;
        }
        return x > 0 ? ret : -ret;
    }
}
