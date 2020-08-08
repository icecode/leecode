package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/8 10:51 上午
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x54pet/
 */
public class Solution23 {

    public static void main(String[] args) {
        System.out.println("ret:" + new Solution23().isPalindrome(121));
        System.out.println("ret:" + new Solution23().isPalindrome(-121));
        System.out.println("ret:" + new Solution23().isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && (x % 10) == 0)) {
            return false;
        }
        return x == reverse(x);
    }

    public int reverse(int x) {
        int xv = x < 0 ? -x : x;
        int ret = 0;
        int tmp;
        while (xv > 0) {
            tmp = ret * 10 + xv % 10;
            if (tmp / 10 != ret) {
                return 0;
            }
            ret = tmp;
            xv /= 10;
        }
        return x > 0 ? ret : -ret;
    }

}
