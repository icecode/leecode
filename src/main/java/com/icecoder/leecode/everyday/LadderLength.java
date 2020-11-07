package com.icecoder.leecode.everyday;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author libing
 * @version 1.0
 * @date 2020/11/6 6:29 下午
 */
public class LadderLength {


    public static void main(String[] args) {
        List<String> ws = new ArrayList<>();
        ws.add("hot");
        ws.add("dot");
        ws.add("dog");
        ws.add("lot");
        ws.add("log");
        ws.add("cog");
        System.out.println("l:" + new LadderLength().ladderLength("hit", "cog", ws));

        ws.remove("cog");
        System.out.println("l:" + new LadderLength().ladderLength("hit", "cog", ws));
    }

    /**
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-ladder
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        Queue<Pair> pathQueue = new ArrayDeque<>();
        pathQueue.add(new Pair(beginWord, 1));
        while (!pathQueue.isEmpty()) {
            Pair t = pathQueue.poll();
            if (t == null) {
                return 0;
            }
            if (t.word.equals(endWord)) {
                return t.level;
            }
            for (int i = 0; i < t.word.length(); i++) {
                String h = t.word.substring(0, i);
                String e = t.word.substring(i + 1);
                for (char j = 'a'; j <= 'z'; j++) {
                    String testWord = h + j + e;
                    if (wordSet.contains(testWord)) {
                        pathQueue.add(new Pair(testWord, t.level + 1));
                        wordSet.remove(testWord);
                    }
                }

            }
        }
        return 0;
    }

    public static class Pair {

        public final String word;

        public final int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}
