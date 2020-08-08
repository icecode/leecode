package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/8 11:14 上午
 *
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x51e9r/
 */
public class Solution24 {

    public static void main(String[] args) {
        System.out.println("ret:" + new Solution24().singleNumber(new int[]{1, 2, 2}));
        System.out.println("ret:" + new Solution24().singleNumber(new int[]{4, 1, 2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        return ret;
    }
}
