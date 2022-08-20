package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://lipcoder.tistory.com/204
 */
@Slf4j
public class Nesting {
    public static void main(String[] args) {
        String S;
        S = "((aa)(a()aa)(aa))";
        S = "((aa)(a()aa)(aa)";

        log.info("{}", solution(S));
    }

    private static int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if(c == '(') {
                stack.push('(');
            }

            if(c == ')') {
                if(stack.empty()) return 0;
                stack.pop();
            }
        }

        if(stack.empty()) return 1;
        return 0;
    }
}
