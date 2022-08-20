package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://lipcoder.tistory.com/204
 */
@Slf4j
public class AbsDistinct {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{-5,-3,-1,0,3,6};

        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        Set<Integer> uniq = new HashSet<>();
        for (int n : A) {
           uniq.add(Math.abs(n));
        }
        return uniq.size();
    }
}
