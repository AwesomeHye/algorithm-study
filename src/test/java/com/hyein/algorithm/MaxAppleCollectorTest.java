package com.hyein.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxAppleCollectorTest {

    @ParameterizedTest
    @MethodSource
    public void test(int[] trees, int t, int u, int answer){
        assertEquals(answer, MaxAppleCollector.getMaxCollectedApples(trees, t, u));
    }

    private static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(new int [] {6, 1, 4, 6, 3, 2, 7, 4}, 2, 3, 24),
                Arguments.of(new int [] {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5}, 3, 2, 17),
                Arguments.of(new int [] {1, 2, 3, 4}, 2, 2, 10),
                Arguments.of(new int [] {10, 19, 15}, 2, 2, -1)
        );
    }



}