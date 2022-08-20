package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{3,3,1,2};
        A = new int[]{3,1,2,4,3};
        A = new int[]{1,1};
        A = new int[]{-1,-2,-3,4,5};
        A = new int[]{-10,-20,-30,-40,100};
        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        if(A.length < 3) return Math.abs(A[0] - A[1]);

        Set<Integer> collection = new HashSet<>();
        int sum = 0;
        for (int n : A) sum += n;

        int left = 0;
        int right = 0;
        for (int i = 0; i < A.length-1; i++) {
            left += A[i];
            right = sum - left;
            collection.add(Math.abs(left - right));
        }
        return Collections.min(collection);
    }

}
