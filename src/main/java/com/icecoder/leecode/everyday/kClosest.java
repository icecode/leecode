package com.icecoder.leecode.everyday;

/**
 *
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 
 * @author libing
 * @version 1.0
 * @date 2020/11/9 8:17 下午
 */
public class kClosest {

    public static void main(String[] args) {
        new kClosest().kClosest(new int[][]{new int[]{2, 2}, new int[]{2, 2}, new int[]{2, 2}, new int[]{2, 2}, new int[]{1, 1}}, 3);
        new kClosest().kClosest(new int[][]{new int[]{9, 0}, new int[]{7, 10}, new int[]{-4, -2}, new int[]{3, -9}, new int[]{9, 1}, new int[]{-5, -1}}, 5);
    }

    public static class Point {

        public final int x;

        public final int y;

        public final int d;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = x * x + y * y;
        }

        @Override
        public String toString() {
            return "[x:" + x + ",y:" + y + " d=" + d + "]";
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        Point[] points1 = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            points1[i] = new Point(points[i][0], points[i][1]);
        }
        sort(points1, 0, points.length - 1, K);
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            ret[i] = new int[]{points1[i].x, points1[i].y};
        }
        return ret;
    }


    public static void sort(Point[] points, int l, int r, int K) {
        if (l >= r) {
            return;
        }
        int i = part(points, l, r);
        if (i >= K) {
            sort(points, l, i - 1, K);
        } else {
            sort(points, i + 1, r, K);
        }
    }

    public static int part(Point[] points, int l, int r) {
        Point pivot = points[l];
        int i = l, j = r + 1;
        while (i < j) {
            while (points[--j].d > pivot.d && j > l) {
                //ignore
            }
            while (points[++i].d < pivot.d && i < r) {
                //ignore
            }
            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, l, j);
        return j;
    }

    public static void swap(Point[] points, int l, int r) {
        Point t = points[l];
        points[l] = points[r];
        points[r] = t;
    }
}
