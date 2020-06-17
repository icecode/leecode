package com.icecoder.leecode.tencent;

import java.util.Optional;

/**
 * @author libing
 * @version 1.0
 * @date 2020/6/10 5:53 下午
 */
public class LongestPalindrome {

    public static void main(String[] argv) {
        System.out.println(new LongestPalindrome().findLongestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("eabcbad"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("abbc"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("abacd"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("cc"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("bcace"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("a"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("aaaa"));
//        System.out.println(new LongestPalindrome().findLongestPalindrome("ccc"));
    }

    public String findLongestPalindrome(String str) {
        if (str.length() == 1) {
            return str;
        } else if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1)) {
                return str;
            } else {
                return str.charAt(0) + "";
            }
        }
        int modIndex = str.length() / 2;
        String leftVal = findLongestPalindromeLeft(str, modIndex);
        String rightVal = findLongestPalindromeRight(str, modIndex);
        String finalVal = leftVal.length() > rightVal.length() ? leftVal : rightVal;
        return "".equals(finalVal) ? str.charAt(0) + "" : finalVal;
    }


    static class Index {

        final int left;

        final int right;

        public Index(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public Optional<Index> getLeftAAIndex(int modIndex) {
        if ((modIndex - 1) >= 0) {
            return Optional.of(new Index(modIndex - 1, modIndex));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Index> getLeftABAIndex(int modIndex) {
        if ((modIndex - 1) >= 0) {
            return Optional.of(new Index(modIndex - 1, modIndex + 1));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Index> getRightAAIndex(String str, int modIndex) {
        if ((modIndex + 1) <= str.length()) {
            return Optional.of(new Index(modIndex, modIndex + 1));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Index> getRightABAIndex(String str, int modIndex) {
        if ((modIndex + 1) <= str.length()) {
            return Optional.of(new Index(modIndex - 1, modIndex + 1));
        } else {
            return Optional.empty();
        }
    }

    public String palindromeTest(String str, Index index) {
        int testStep = 0;
        while ((index.left - testStep) >= 0 &&
                (index.right + testStep) < str.length() &&
                str.charAt(index.left - testStep) == str.charAt(index.right + testStep)) {
            testStep += 1;
        }
        if (testStep == 0) {
            return "";
        } else {
            return str.substring(index.left - testStep + 1, index.right + testStep);
        }
    }

    public String findLongestPalindromeLeft(String str, final int modIndex) {
        if (modIndex == 0) {
            return "";
        }
        String curAa = getLeftAAIndex(modIndex).map(index -> palindromeTest(str, index)).orElse("");
        String curAba = getLeftABAIndex(modIndex).map(index -> palindromeTest(str, index)).orElse("");
        String curVal = curAa.length() > curAba.length() ? curAa : curAba;
        String subValue = findLongestPalindromeLeft(str, modIndex - 1);
        return curVal.length() > subValue.length() ? curVal : subValue;
    }

    public String findLongestPalindromeRight(String str, final int modIndex) {

        if ((modIndex + 1) >= str.length()) {
            return "";
        }
        String curAa = getRightAAIndex(str, modIndex).map(index -> palindromeTest(str, index)).orElse("");
        String curAba = getRightABAIndex(str, modIndex).map(index -> palindromeTest(str, index)).orElse("");
        String curVal = curAa.length() > curAba.length() ? curAa : curAba;
        String subValue = findLongestPalindromeRight(str, modIndex + 1);
        return curVal.length() > subValue.length() ? curVal : subValue;
    }
}
