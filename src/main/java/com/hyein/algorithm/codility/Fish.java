package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class Fish {
    public static int solution(int[] A, int[] B) {
        if(A.length == 1) return 1;
        Stack<Integer> fishes = new Stack<>(); // key: idx
        for (int i = 0; i < A.length; i++) {

            int p;
             while (!fishes.empty()) {
                p = fishes.peek();
                if (!(B[p] == 1 && B[i] == 0)) {
                    fishes.push(i);
                    break;
                }

                if (A[p] < A[i]) {
                    fishes.pop();
                } else break;
            }

            if (fishes.empty()) {
                fishes.push(i);
            }
        }

        return fishes.size();
    }
}
