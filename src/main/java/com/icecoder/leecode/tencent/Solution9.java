package com.icecoder.leecode.tencent;

import java.util.*;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/23 7:42 下午
 */
public class Solution9 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution9().spiralOrder(new int[][]{}).toArray()));
        System.out.println(Arrays.toString(new Solution9().spiralOrder(new int[][]{{1, 2}, {4, 3}}).toArray()));
        System.out.println(Arrays.toString(new Solution9().spiralOrder(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}).toArray()));
        System.out.println(Arrays.toString(new Solution9().spiralOrder(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}).toArray()));
        System.out.println(Arrays.toString(new Solution9().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).toArray()));
        System.out.println(Arrays.toString(new Solution9().spiralOrder(new int[][]{{1, 2, 3, 4}}).toArray()));
        System.out.println(Arrays.toString(new Solution9().spiralOrder(new int[][]{{1}, {2}, {3}, {4}}).toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        ArrayList<Integer> v = new ArrayList<>(matrix.length * matrix[0].length);
        int level = 0;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        ArrayList<Integer> v1 = new ArrayList<>((rowCount + colCount) * 2);
        while (true) {
            int colBorder = colCount - 1 - level;
            int rowBorder = rowCount - 1 - level;
            for (int i = level; i < colCount - level && level <= rowBorder; i++) {
                v1.add(matrix[level][i]);
            }
            for (int i = level + 1; i < rowCount - level && level <= colBorder; i++) {
                v1.add(matrix[i][colBorder]);
            }
            for (int i = colBorder - 1; i > level && level < rowBorder; i--) {
                v1.add(matrix[rowBorder][i]);
            }
            for (int i = rowBorder; i > level && level < colBorder ; i--) {
                v1.add(matrix[i][level]);
            }
            v.addAll(v1);
            if (v1.isEmpty()) {
                break;
            }
            v1.clear();
            level++;
        }
        return v;
    }
}
