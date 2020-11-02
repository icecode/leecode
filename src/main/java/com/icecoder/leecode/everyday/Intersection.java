package com.icecoder.leecode.everyday;

import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author libing
 * @version 1.0
 * @date 2020/11/2 9:10 下午
 */
public class Intersection {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Intersection().intersection(new int[]{1, 2, 2}, new int[]{2, 2})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        int[] ret = new int[Math.min(nums1.length, nums2.length)];
        int retIndex = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                ret[retIndex++] = nums1[i1];
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        if (retIndex == 0) {
            return new int[]{};
        }
        int writeIndex = 0, readIndex = 1;
        while (readIndex < retIndex) {
            if (ret[writeIndex] != ret[readIndex]) {
                ret[++writeIndex] = ret[readIndex];
            }
            readIndex++;
        }
        return Arrays.copyOf(ret, writeIndex + 1);
    }
}
