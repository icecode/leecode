package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/13 6:36 下午
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x5yjhd/
 *
 */
public class Solution27 {

    public static void main(String[] args) {
        System.out.println("ret:" + new Solution27().isPowerOfTwo(1));
        System.out.println("ret:" + new Solution27().isPowerOfTwo(2));
        System.out.println("ret:" + new Solution27().isPowerOfTwo(3));
        System.out.println("ret:" + new Solution27().isPowerOfTwo(4));
        System.out.println("ret:" + new Solution27().isPowerOfTwo(6));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
