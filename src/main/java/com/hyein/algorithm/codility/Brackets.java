package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * https://lipcoder.tistory.com/204
 */
@Slf4j
public class Brackets {
    public static void main(String[] args) {
        String S;
        S = "([)()]";
        S = "((aa)(a()aa)(aa))";
        S = "{[()()]}";

        log.info("{}", solution(S));
    }

    private static int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if(c == ')') {
                if(stack.empty() || stack.pop() != '(') return 0;
            } else if(c == '}') {
                if(stack.empty() || stack.pop() != '{') return 0;
            } else if(c == ']') {
                if(stack.empty() || stack.pop() != '[') return 0;
            }
        }

        return stack.empty() ? 1 : 0;
    }
}
