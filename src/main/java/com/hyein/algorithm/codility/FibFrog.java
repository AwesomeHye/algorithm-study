package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Deprecated
@Slf4j
public class FibFrog {
    public static void main(String[] args) {
        int[] A ;
        A = new int[]{3,3,1,2};
        A = new int[]{2,5,1,4,6,7,9,10,1};
        A = new int[]{8,8,5,7,9,8,7,4,8};
        log.info("{}", solution(A));
    }

    private static int solution(int[] H) {
        List<Integer> fib = new ArrayList<>();
        fib.add(0); fib.add(1);
        while(fib.get(fib.size()-1) < H.length) {
            fib.add((fib.get(fib.size()-1)) + ((fib.get(fib.size()-2))));
        }

        log.info(fib.toString());
        return 0;
    }
}
