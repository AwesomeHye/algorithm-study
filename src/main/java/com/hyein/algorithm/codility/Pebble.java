package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pebble {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{2,5,1,4,6,7,9,10,1};
        A = new int[]{1,-2,0,9,-1,-2};
        A = new int[]{3,3,1,2};
        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        if(A.length < 3) return A[0] + A[A.length - 1];
        int sum = A[0] + A[A.length - 1];
        int peek = 0;
        int i = 1;
        while(peek < A.length-1) {
           if(peek + i > A.length-1) break;

           if(A[peek + i] > 0) {
               peek = peek + i;
               sum += A[peek + i];
               i = 1;
           } else {
               i = i % 6 + 1;
           }
        }

        return sum;
    }
}
