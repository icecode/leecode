package com.icecoder.leecode.everyday;

/**
 * @author libing
 * @version 1.0
 * @date 2020/11/3 8:05 下午
 */
public class MountainArrayTest {

    public static void main(String[] args) {
        System.out.println(new MountainArrayTest().validMountainArray(new int[]{2, 1}));
        System.out.println(new MountainArrayTest().validMountainArray(new int[]{3, 5, 5}));
        System.out.println(new MountainArrayTest().validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(new MountainArrayTest().validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }


    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        return (validMountainArrayLeft(A, A.length / 2) || validMountainArrayRight(A, A.length / 2 + 1));
    }

    public boolean realValidMountainArray(int[] A, int centralIndex) {
        if (centralIndex < 1) {
            return false;
        }
        if ((centralIndex + 1) >= A.length) {
            return false;
        }
        int leftIndex = centralIndex - 1;
        int rightIndex = centralIndex + 1;
        while (leftIndex >= 0 && A[leftIndex] < A[leftIndex + 1]) {
            leftIndex--;
        }
        while (rightIndex < A.length && A[rightIndex - 1] > A[rightIndex]) {
            rightIndex++;
        }
        return (leftIndex == -1 && rightIndex == A.length);
    }

    public boolean validMountainArrayLeft(int[] A, int centralIndex) {
        return (realValidMountainArray(A, centralIndex) || (centralIndex > 1 && validMountainArrayLeft(A, centralIndex - 1)));
    }

    public boolean validMountainArrayRight(int[] A, int centralIndex) {
        return (realValidMountainArray(A, centralIndex) || (centralIndex < A.length && validMountainArrayRight(A, centralIndex + 1)));
    }
}
