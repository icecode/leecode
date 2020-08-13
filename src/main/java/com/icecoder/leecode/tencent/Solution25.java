package com.icecoder.leecode.tencent;

import java.util.Arrays;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/8 11:14 上午
 *
 * 数组中只有两个元素只出现一次，其余的元素都出现两次，求这个2元素
 *
 * 示例 1:
 *
 * 输入: [2,2,1,3]
 * 输出: 1,3
 * 示例 2:
 *
 * 输入: [4,1,2,1,2,5]
 * 输出: 4,5
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x51e9r/
 */
public class Solution25 {

    public static void main(String[] args) {
        System.out.println("ret:" + Arrays.toString(new Solution25().singleNumber(new int[]{1, 2, 2, 3})));
        System.out.println("ret:" + Arrays.toString(new Solution25().singleNumber(new int[]{4, 1, 2, 2, 1, 5})));
    }

    public int[] singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            if (ret == (nums[i] ^ nums[i - 1])) {
                return new int[]{nums[i - 1], nums[i]};
            }
        }
        return new int[]{};
    }
}
