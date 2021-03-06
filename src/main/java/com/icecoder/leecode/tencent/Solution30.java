package com.icecoder.leecode.tencent;

import java.util.Arrays;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/20 8:33 下午
 */
public class Solution30 {

    public static void main(String[] args) {
        System.out.println("ret:" + new Solution30().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println("ret:" + new Solution30().findKthLargest(new int[]{1}, 1));
        System.out.println("ret:" + new Solution30().findKthLargest(new int[]{ 3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    /**
     * 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/tencent/x5txi7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums[k - 1];
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k - 1, 0, nums.length - 1);
    }

    public int partition(int[] nums, int start, int end) {
        int i = start, j = end + 1;
        int pivot = nums[start];
        int tmp;
        while (true) {
            while (nums[++i] > pivot) {
                if (i == end) {
                    break;
                }
            }
            while (nums[--j] < pivot) {
                if (j == start) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[start] = nums[j];
        nums[j] = pivot;
        return j;
    }

    public int findKthLargest(int[] nums, int k, int start, int end) {
        if (start >= end) {
            return nums[k];
        }
        int sk = partition(nums, start, end);
        if (sk >= k) {
            return findKthLargest(nums, k, start, sk - 1);
        } else {
            return findKthLargest(nums, k, sk + 1, end);
        }
    }
}
