package com.icecoder.leecode.everyday;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author libing
 * @version 1.0
 * @date 2020/11/16 10:54 下午
 */
public class ReconstructQueue {

    public static void main(String[] args) {
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        Arrays.stream(reconstructQueue.reconstructQueue(new int[][]{new int[]{7, 0}, new int[]{4, 4}, new int[]{5, 0}, new int[]{6, 1}, new int[]{5, 2}, new int[]{7, 1}}))
        .forEach( v -> System.out.print(Arrays.toString(v) + ","));
    }

    public int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length) {
            return new int[0][0];
        }
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }
}
