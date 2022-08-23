package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{-3,1,2,-2,5,6};
        A = new int[]{-100,3,2,1};
        A = new int[]{-100,-3,2,1};
        A = new int[]{-100,-3,-2,1};
        A = new int[]{-100,-3,-2};
        A = new int[]{-100,-3,-2,-4};
        A = new int[]{-100,-3,-2,4};
        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);
        int ans1 = A[A.length-1] * A[A.length-2] * A[A.length-3];

        // 음수 2개일 때와 양수 3개일 때를 비교
        if(A[0] < 0 && A[1] < 0 && A[A.length-1] > 0) {
            int ans2 = A[0] * A[1] * A[A.length-1];
            return Math.max(ans1, ans2);
        }

        return ans1;
    }
}
