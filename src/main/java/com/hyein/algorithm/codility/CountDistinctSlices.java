package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class CountDistinctSlices {
    private static int[] B;
    private static int max = 0;

    public static void main(String[] args) {
        int[] A ;
        A = new int[]{3,4,5,5,2};
        A = new int[]{3,4,5,2,5};
        A = new int[]{1,2,2,2,3,2,4,5};

        int M = 0;
        M = 6;
        log.info("{}", solution(M, A));
    }

    public static int solution(int M, int[] A) {
        int end = 0;
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int start = 0; start < A.length; start++) {
            if(start != 0) {
                set.remove(A[start - 1]);
                cnt += set.size();
                if(cnt > 1_000_000_000) return 1_000_000_000;
            }
            while(end < A.length) {
                if(!set.add(A[end])) {
                    break;
                }
                cnt++;
                end++;
                if(cnt > 1_000_000_000) return 1_000_000_000;
            }
        }
        return cnt;
    }

}
