package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/13 6:07 下午
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x5yxxs/
 */
public class Solution26 {

    public static void main(String[] args) {
        System.out.println("ret: " + new Solution26().majorityElement(new int[]{2, 3, 3}));
        System.out.println("ret: " + new Solution26().majorityElement(new int[]{2, 2, 1, 1, 1, 1, 1, 2, 2}));
    }

    public int majorityElement(int[] nums) {
        int ret = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ret = nums[i];
            }
            count += (ret == nums[i] ? 1 : -1);
        }
        return ret;
    }
}
