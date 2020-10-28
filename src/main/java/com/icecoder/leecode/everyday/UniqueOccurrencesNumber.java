package com.icecoder.leecode.everyday;

import java.util.Arrays;

/**
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author libing
 * @version 1.0
 * @date 2020/10/28 8:32 上午
 */
public class UniqueOccurrencesNumber {


    public static void main(String[] args) {
        System.out.println("r:" + new UniqueOccurrencesNumber().uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println("r:" + new UniqueOccurrencesNumber().uniqueOccurrences(new int[]{3,0,1,-3,1,1,1,-3,10,0}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] v2 = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i] + 1000;
            v2[v] += 1;
        }
        int vIndex = 0;
        for (int i = 0; i < v2.length; i++) {
            if (v2[i] != 0) {
                v2[vIndex++] = v2[i];
            }
        }
        v2 = Arrays.copyOf(v2, vIndex);
        Arrays.sort(v2);
        for (int i = 1; i < v2.length; i++) {
            if (v2[i] > 0 && v2[i-1] == v2[i]) {
                return false;
            }
        }
        return true;
    }
}
