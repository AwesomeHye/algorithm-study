package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * https://lipcoder.tistory.com/204
 */
@Slf4j
public class FrogJum {
    public static void main(String[] args) {
//        int X = 10, Y = 85, D = 30;
//        int X = 10, Y = 85, D = 30;
        int X = 10, Y = 8554445, D = 7;
        log.info("{}", solution(X, Y, D));
    }

    private static int solution(int X, int Y, int D) {
        return (int) Math.ceil((double) (Y-X) / D);
    }


}
