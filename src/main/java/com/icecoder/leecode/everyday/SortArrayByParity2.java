package com.icecoder.leecode.everyday;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author libing
 * @version 1.0
 * @date 2020/11/12 11:06 下午
 */
public class SortArrayByParity2 {

    public static void main(String[] args) {
        int[] A = new int[]{2, 0, 3, 4, 1, 3};
        new SortArrayByParity2().sortArrayByParityII(A);
        System.out.println("v:" + Arrays.toString(A));

        int[] A1 = new int[]{3, 1, 4, 2};
        new SortArrayByParity2().sortArrayByParityII(A1);
        System.out.println("v:" + Arrays.toString(A1));
    }

    public int[] sortArrayByParityII(int[] A) {
        int t;
        for (int i = 1, j = 0; i < A.length; i += 2) {
            if ((A[i] % 2) == 0) {
                while (j < A.length) {
                    if ((A[j] % 2) != 0) {
                        t = A[j];
                        A[j] = A[i];
                        A[i] = t;
                        j += 2;
                        break;
                    }
                    j += 2;
                }
            }
        }
        return A;
    }
}
