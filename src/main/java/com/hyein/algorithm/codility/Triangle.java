package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public class Triangle {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{10,2,5,8,10,20};
        A = new int[]{3,Integer.MAX_VALUE,5};
        A = new int[]{Integer.MAX_VALUE,3,5};
        A = new int[]{3,Integer.MAX_VALUE,Integer.MAX_VALUE};
        A = new int[]{10,50,5,1};
        A = new int[]{-2,-2,-2};
        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length-2; i++) {
            if(A[i] > A[i+2] - A[i+1] ) return 1;
        }
        return 0;
    }


}
