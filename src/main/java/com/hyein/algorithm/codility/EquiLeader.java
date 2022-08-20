package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EquiLeader {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{4,3,4,4,4,2};
        log.info("{}", solution(A));
    }

    private static int solution(int[] A) {
        if(A.length < 2) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            map.merge(n, 1, Integer::sum);
        }

        int leader = 0, leaderCnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > A.length / 2) {
                leader = entry.getKey();
                leaderCnt = entry.getValue();
            }
        }
        if(leaderCnt == 0) {
            return 0;
        }

        int leftLeaderCnt = 0;
        int rightLeaderCnt = 0;
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == leader) {
                leftLeaderCnt++;
                rightLeaderCnt = leaderCnt-leftLeaderCnt;
            }

            if((leftLeaderCnt > ((i+1)/2)) && (rightLeaderCnt > ((A.length-(i+1))/2))) answer++;
        }

        return answer;
    }



}
