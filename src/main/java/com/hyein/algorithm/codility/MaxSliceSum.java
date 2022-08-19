package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSliceSum {
    private static int[] B;
    private static int max = 0;

    public static void main(String[] args) {
        int[] A ;
        A = new int[]{8,8,5,7,9,8,7,4,8};
        A = new int[]{3,2,-6,4,0};
        A = new int[]{3,3,1,-200};
        A = new int[]{-10,-20,-30,-40};
        A = new int[]{-20,-30,-40,-10};
        log.info("{}", solution(A));
    }

    public static int solution(int[] A) {
        if(A.length == 1) return A[0];

        int local = A[0];
        int global = A[0];
        for (int i = 1; i < A.length; i++) {
            local = Math.max(local + A[i], A[i]);
            global = Math.max(local, global);
        }

        return global;
    }

}
