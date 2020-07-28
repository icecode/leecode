package com.icecoder.leecode.tencent;

import java.util.Arrays;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/28 7:43 下午
 */
public class Solution11 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution11().merge2(new int[]{1}, 1, new int[]{}, 0)));
        System.out.println(Arrays.toString(new Solution11().merge2(new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3)));
        System.out.println(Arrays.toString(new Solution11().merge2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3)));
    }

    public int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int c = m + n;
        while (c > 0) {
            if (m == 0) {
                nums1[--c] = nums2[--n];
            } else if (n == 0) {
                nums1[--c] = nums1[--m];
            } else {
                nums1[--c] = nums1[m - 1] < nums2[n - 1] ? nums2[--n] : nums1[--m];
            }
        }
        return nums1;
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            boolean inserted = false;
            for (; j < m + i; j++) {
                if (nums2[i] < nums1[j]) {
                    for (int k = m + i; k > j ; k--) {
                        nums1[k] = nums1[k - 1];
                    }
                    nums1[j] = nums2[i];
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                nums1[m + i] = nums2[i];
            }
        }
        return nums1;
    }

}
