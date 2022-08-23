package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class CyclicRotation {
    public static int[] solution(int[] A, int K) {
        int length = A.length;
        // empty array 체크!!
        if(length == 0) return A;

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[(i+K)%length] = A[i];
        }
        return ans;
    }

}
