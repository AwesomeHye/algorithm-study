package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class BinaryGap {
    public static void main(String[] args) {
        log.info("{}", solution(1041));
    }

    public static int solution(int N) {
        // 정수를 이진수로 바꾸는 메소드
        String binary = Integer.toBinaryString(N);
        log.info("{}", binary);

        char[] chars = binary.substring(binary.indexOf("1"), binary.lastIndexOf("1") + 1).toCharArray();

        int sum = 0, max = 0;
        for (int i = 0; i < chars.length; i++) {
            char val = chars[i];
            if(val == '1') {
                max = Math.max(sum, max);
                sum = 0;
            } else {
                sum++;
            }

        }
        return max;
    }




}
