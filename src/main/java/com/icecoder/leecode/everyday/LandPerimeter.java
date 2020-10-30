package com.icecoder.leecode.everyday;

import java.util.Arrays;

/**
 *
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 
 * @author libing
 * @version 1.0
 * @date 2020/10/30 1:37 下午
 */
public class LandPerimeter {


    public static void main(String[] args) {
        int[][] v = new int[][]{new int[]{0, 1, 0, 0}, new int[]{1, 1, 1, 0}, new int[]{0, 1, 0, 0},new int[]{1, 1, 0, 0}};
        System.out.println("perimeter:" + new LandPerimeter().islandPerimeter(v));
        int[][] v1 = new int[][]{new int[]{0, 1, 0, 0}};
        System.out.println("perimeter:" + new LandPerimeter().islandPerimeter(v1));
        int[][] v2 = new int[][]{new int[]{1}, new int[]{0}};
        System.out.println("perimeter:" + new LandPerimeter().islandPerimeter(v2));
        int[][] v3 = new int[][]{new int[]{0}, new int[]{1}};
        System.out.println("perimeter:" + new LandPerimeter().islandPerimeter(v3));
        int[][] v4 = new int[][]{new int[]{0, 1, 1}, new int[]{1, 1, 0}};
        System.out.println("perimeter:" + new LandPerimeter().islandPerimeter(v4));
    }

    public int islandPerimeter(int[][] grid) {
        int realH = grid.length;
        if (realH == 0) {
            return 0;
        }
        int realW = grid[0].length;
        int[][] copy = new int[realH + 2][realW + 2];
        for (int i = 0; i < realH; i++) {
            int[] cv = new int[realW + 2];
            System.arraycopy(grid[i], 0, cv, 1, realW);
            copy[i + 1] = cv;
        }
        copy[realH + 1] = new int[realW + 2];
        int perimeter = 0;
        for (int i = 1; i <= realH; i++) {
            for (int j = 1; j <= realW; j++) {
                if (copy[i][j] == 1) {
                    perimeter += copy[i][j - 1] == 0 ? 1 : 0;
                    perimeter += copy[i][j + 1] == 0 ? 1 : 0;
                    perimeter += copy[i - 1][j] == 0 ? 1 : 0;
                    perimeter += copy[i + 1][j] == 0 ? 1 : 0;
                }
            }
        }
        return perimeter;
    }
}
