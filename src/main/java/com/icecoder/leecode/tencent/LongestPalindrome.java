package com.icecoder.leecode.tencent;

import java.util.function.Function;

/**
 * @author libing
 * @version 1.0
 * @date 2020/6/10 5:53 下午
 */
public class LongestPalindrome {

    public static void main(String[] argv) {
        System.out.println(new LongestPalindrome().findLongestPalindrome("babad"));
        System.out.println(new LongestPalindrome().findLongestPalindrome("babab"));
    }

    public String findLongestPalindrome(String str) {
        int rightIndex = str.length() / 2;
        int leftIndex = rightIndex - 1;
        String leftVal = findLongestPalindrome(str, leftIndex, index -> index - 1);
        String rightVal = findLongestPalindrome(str, rightIndex, index -> index + 1);
        return leftVal.length() > rightVal.length() ? leftVal : rightVal;
    }

    public String findLongestPalindrome(String str, final int modIndex, final Function<Integer, Integer> nextStateFunc) {
        if (modIndex == 0 || (modIndex + 1) >= str.length()) {
            return "";
        }
        int chkIndex = 1;
        while ((modIndex - chkIndex) >= 0 && (modIndex + chkIndex) < str.length()) {
            if (str.charAt(modIndex - chkIndex) == str.charAt(modIndex + chkIndex)) {
                chkIndex++;
            } else {
                break;
            }
        }
        chkIndex--;
        String curVal = chkIndex > 0 ? str.substring(modIndex - chkIndex, modIndex + chkIndex + 1) : "";
        String subVal = findLongestPalindrome(str, nextStateFunc.apply(modIndex), nextStateFunc);
        return curVal.length() > subVal.length() ? curVal : subVal;
    }
}
