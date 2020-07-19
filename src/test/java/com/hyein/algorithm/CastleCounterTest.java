package com.hyein.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastleCounterTest {

    @ParameterizedTest
    @MethodSource
    public void test(int A[], int answer){
        assertEquals(answer, CastleCounter.Solution(A));
    }

    private static Stream<Arguments> test(){
        return Stream.of(
                Arguments.of(new int [] {2,2,3,4,3,3, 2, 2, 1, 1, 2, 5}, 4),
                Arguments.of(new int [] {2}, 1),
                Arguments.of(new int [] {-3, -3}, 1),
                Arguments.of(new int [] {2, 2, 4}, 2),
                Arguments.of(new int [] {2, 4, 4}, 2),
                Arguments.of(new int [] {1, 2, 3, 4, 5}, 2)
        );
    }


}