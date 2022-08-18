package com.hyein.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkCounterTest {


    @ParameterizedTest
    @MethodSource
    public void test(int n, int[][] computers, int answer){

        assertEquals(answer, NetworkCounter.solution(n, computers));
    }

    private static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(3,  new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
                Arguments.of(3,  new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, 1),
                Arguments.of(4,  new int[][]{{1, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}}, 2),
                Arguments.of(4,  new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}, 4),
                Arguments.of(4,  new int[][]{{1, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 1}}, 1)

        );
    }



}