package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/18 8:02 上午
 */
public class Solution29 {


    //[]
    //6
    public static void main(String[] args) {
        System.out.println("r:" + new Solution29().search(new int[]{ 4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("r:" + new Solution29().search(new int[]{ 4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("r:" + new Solution29().search(new int[]{ 6, 7, 1, 2, 3, 4, 5}, 6));
    }

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/tencent/x5ueu1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (nums[start] > nums[mid] || nums[mid] > nums[end]) {
            //当前点是旋转点,2边都要搜索
            int lrt = search(nums, target, start, mid - 1);
            int rrt = search(nums, target, mid + 1, end);
            return lrt == -1 ? rrt : lrt;
        } else if (nums[mid] > target) {
            return search(nums, target, start, mid - 1);
        } else {
            return search(nums, target, mid + 1, end);
        }
    }
}
