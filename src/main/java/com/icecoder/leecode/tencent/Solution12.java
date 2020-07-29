package com.icecoder.leecode.tencent;

import java.util.Arrays;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/29 9:19 上午
 */
public class Solution12 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution12().productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(new Solution12().productExceptSelf(new int[]{1,2})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int leftVal = 1;
        for (int i = 0; i < nums.length; i++) {
            ret[i] = leftVal;
            leftVal *= nums[i];
        }
        int rightVal = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            ret[i] *= rightVal;
            rightVal *= nums[i];
        }
        return ret;
    }
}
