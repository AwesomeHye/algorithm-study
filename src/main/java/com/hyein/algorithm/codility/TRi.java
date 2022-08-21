package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class TRi {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{-3,1,2,-2,5,6};
        A = new int[]{-100,3,2,1};
        A = new int[]{-100,-3,2,1};
        A = new int[]{-100,-3,-2,1};
        A = new int[]{-100,-3,-2};
        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        if(A.length == 3) return A[0] * A[1] * A[2];

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int n : A) {
            if(n >= 0) positive.add(n);
            else negative.add(n);
        }

        Collections.sort(positive, Comparator.reverseOrder());
        Collections.sort(negative);

        if(positive.size() == 1 || positive.size() == 2) {
            return positive.get(0) * negative.get(0) * negative.get(1);
        } else {
            if(negative.size() > 1)
                return Math.max(positive.get(0) * negative.get(0) * negative.get(1), positive.get(0) * positive.get(1) * positive.get(2));
            else
                return positive.get(0) * positive.get(1) * positive.get(2);
        }
    }
}
