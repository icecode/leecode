package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/6/9 8:48 下午
 */
public class FindMedian {

    public static void main(String[] argv) {
        int[] v1 = new int[]{1, 4, 6};
        int[] v2 = new int[]{2, 5, 8};
        System.out.println("mid:" + findMedianSortedArrays(v1, v2));
        int[] v3 = new int[]{1, 2};
        int[] v4 = new int[]{3};
        System.out.println("mid:" + findMedianSortedArrays(v3, v4));
        int[] v5 = new int[]{1, 2};
        int[] v6 = new int[]{3, 4};
        System.out.println("mid:" + findMedianSortedArrays(v5, v6));
        int[] v7 = new int[]{};
        int[] v8 = new int[]{2, 3};
        System.out.println("mid:" + findMedianSortedArrays(v7, v8));
    }

    public static double findMedianSortedArrays(int[] val1, int[] val2) {
        int[] mval = new int[val1.length + val2.length];
        int i = 0, j = 0, m = 0;
        int midIndex = mval.length / 2;
        while (j < val2.length && i < val1.length) {
            if (val1[i] < val2[j]) {
                mval[m++] = val1[i];
                i++;
            } else {
                mval[m++] = val2[j];
                j++;
            }
            if (m > midIndex) {
                return (mval.length % 2 == 0 ? ((mval[midIndex - 1]) + mval[midIndex]) / 2.0 : mval[mval.length / 2]);
            }
        }
        while (i < val1.length) {
            mval[m++] = val1[i++];
        }
        if (m > midIndex) {
            return (mval.length % 2 == 0 ? ((mval[midIndex - 1]) + mval[midIndex]) / 2.0 : mval[mval.length / 2]);
        }
        while (j < val2.length) {
            mval[m++] = val2[j++];
        }
        return (mval.length % 2 == 0 ? ((mval[midIndex - 1]) + mval[midIndex]) / 2.0 : mval[mval.length / 2]);
    }
}
