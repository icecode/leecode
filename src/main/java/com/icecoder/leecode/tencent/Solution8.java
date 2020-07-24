package com.icecoder.leecode.tencent;

import java.util.Arrays;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/23 7:28 下午
 */
public class Solution8 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
