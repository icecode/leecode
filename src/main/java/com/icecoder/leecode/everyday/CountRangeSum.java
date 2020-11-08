package com.icecoder.leecode.everyday;

/**
 * @author libing
 * @version 1.0
 * @date 2020/11/7 6:07 下午
 */
public class CountRangeSum {

    public static void main(String[] args) {
        System.out.println(new CountRangeSum().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(new CountRangeSum().countRangeSum(new int[]{0}, 0, 0));
        System.out.println(new CountRangeSum().countRangeSum(new int[]{-1, 1}, 0, 0));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int rangeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            long s = 0;
            for (int j = i; j < nums.length; j++) {
                s += nums[j];
                if (s >= lower && s <= upper) {
                    rangeSum += 1;
                }
            }
        }
        return rangeSum;
    }
}
