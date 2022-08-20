package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

@Deprecated
@Slf4j
public class MaxNonoverlappingSegments {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{1,3,7,9,9};
        A = new int[]{1,5,7,12,13};

        int[] B ;
        B = new int[]{5,6,8,9,10};
        B = new int[]{4,8,10,15,16};
        log.info("{}", solution(A, B));
    }

    private static int solution(int[] A, int[] B) {
        if(A.length == 0) return 0;
        int max = B[0];
        int cnt = 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] > max) {
                cnt++;
                max = B[i];
            }
        }
        return cnt;
    }
}
