package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TieRopes {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{1_000_000_000, 1_000_000_000, 1_000_000_000};
        A = new int[]{4};
        int K;
        K = 1_000_000_000;
        K = 4;
        log.info("{}", solution(K, A));
    }

    private static int solution(int K, int[] A) {
        int sum = 0, cnt = 0;

        for (int n : A) {
            if((sum += n) >= K) {
                cnt++;
                sum = 0;
            }
        }
        return cnt;
    }
}
