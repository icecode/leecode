package com.icecoder.leecode.tencent;

import java.util.*;

/**
 * @author libing
 * @version 1.0
 * @date 2020/6/25 12:23 下午
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int ret = nums[i] + nums[left] + nums[right];
                if (ret == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                } else if (ret > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
