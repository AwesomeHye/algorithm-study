package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class PermMissingElem {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{2,3,1,5};
        A = new int[]{5};
        A = new int[]{100000,99998};
        A = new int[]{3,1};
        A = new int[]{1,2,3};
        A = new int[]{2,3,4};
        A = new int[]{2};
        A = new int[]{};
        A = new int[]{1};
        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
