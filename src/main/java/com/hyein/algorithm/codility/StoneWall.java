package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * https://lipcoder.tistory.com/204
 */
@Slf4j
public class StoneWall {
    public static void main(String[] args) {
        int[] wall ;
        wall = new int[]{3,3,1,2};
        wall = new int[]{2,5,1,4,6,7,9,10,1};
        wall = new int[]{8,8,5,7,9,8,7,4,8};
        log.info("{}", solution(wall));
    }

    private static int solution(int[] H) {
        Stack<Integer> stone = new Stack<>();
        int cnt = 0, peek = 0;

        for (int i : H) {
            while(!stone.empty()) {
                peek = stone.peek();
                if(i > peek) {
                    stone.push(i);
                    break;
                } else if(i < peek) {
                    cnt++;
                    stone.pop();
                } else break;
            }

            if(stone.empty()) {
                stone.push(i);
            }
        }
        return cnt + stone.size();
    }
}
