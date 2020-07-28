package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/7/28 7:36 上午
 */
public class Solution10 {

    public static void main(String[] args) {
        int[][] ret = new Solution10().generateMatrix(3);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(String.format("%3d", ret[i][j]));
            }
            System.out.println();
        }

        int[][] ret2 = new Solution10().generateMatrix(2);
        for (int i = 0; i < ret2.length; i++) {
            for (int j = 0; j < ret2[0].length; j++) {
                System.out.print(String.format("%3d", ret2[i][j]));
            }
            System.out.println();
        }

        int[][] ret3 = new Solution10().generateMatrix(1);
        for (int i = 0; i < ret3.length; i++) {
            for (int j = 0; j < ret3[0].length; j++) {
                System.out.print(String.format("%3d", ret3[i][j]));
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int colCount = n;
        int rowCount = n;
        int level = 0;
        int val = 0;
        while (true) {
            int fillVal = 0;
            int colBorder = colCount - 1 - level;
            int rowBorder = rowCount - 1 - level;
            for (int i = level; i <= colBorder; i++) {
                ret[level][i] = ++val;
                ++fillVal;
            }
            for (int i = level + 1; i <= rowBorder; i++) {
                ret[i][colBorder] = ++val;
                ++fillVal;
            }
            for (int i = colBorder - 1; i > level; i--) {
                ret[rowBorder][i] = ++val;
                ++fillVal;
            }
            for (int i = rowBorder; i > level ; i--) {
                ret[i][level] = ++val;
                ++fillVal;
            }
            level++;
            if (fillVal == 0) {
                break;
            }
        }
        return ret;
    }
}
