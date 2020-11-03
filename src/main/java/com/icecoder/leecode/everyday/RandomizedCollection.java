package com.icecoder.leecode.everyday;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 
 * @author libing
 * @version 1.0
 * @date 2020/10/31 10:04 上午
 */
public class RandomizedCollection {


    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println("insert 1:" + randomizedCollection.insert(0));
        System.out.println("insert 1:" + randomizedCollection.insert(1));
        System.out.println("insert 1:" + randomizedCollection.remove(0));
        System.out.println("insert 1:" + randomizedCollection.insert(2));
        System.out.println("insert 2:" + randomizedCollection.remove(1));
        System.out.println("insert 2:" + randomizedCollection.insert(1));
        System.out.println("random r:" + randomizedCollection.getRandom());
        System.out.println("random r:" + randomizedCollection.getRandom());
        System.out.println("random r:" + randomizedCollection.getRandom());
    }

    private HashMap<Integer, Set<Integer>> elementMap = new HashMap<>();

    private List<Integer> elements = new ArrayList<>();

    private int size = 0;

   /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        elements.add(size, val);
        Set<Integer> elmIndex = elementMap.get(val);
        boolean ret = (elmIndex == null);
        if (elmIndex == null) {
            elmIndex = new HashSet<>();
        }
        elmIndex.add(size);
        elementMap.put(val, elmIndex);
        size++;
        return ret;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> elmIndex = elementMap.get(val);
        if (elmIndex == null) {
            return false;
        }
        int removeElmIndex = elmIndex.iterator().next();
        elmIndex.remove(removeElmIndex);
        if (elmIndex.isEmpty()) {
            elementMap.remove(val);
        }
        Integer replaceElm = elements.get(size - 1);
        if (elements.size() > 1 && (removeElmIndex != (size - 1))) {
            elements.set(removeElmIndex, replaceElm);
            //更新交换元素的索引
            Set<Integer> replaceElmIndex = elementMap.get(replaceElm);
            replaceElmIndex.remove(size - 1);
            replaceElmIndex.add(removeElmIndex);
        }
        size--;
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return elements.get(ThreadLocalRandom.current().nextInt(size));
    }
}
