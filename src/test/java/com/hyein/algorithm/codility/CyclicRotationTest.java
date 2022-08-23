package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CyclicRotationTest {

    @ParameterizedTest
    @MethodSource
    public void test(int[] ans, int[] A, int K) {
        assertAll(() -> {
            assertArrayEquals(ans, CyclicRotation.solution(A, K));

        });
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}, 1),
                Arguments.of(new int[]{}, new int[]{}, 0),
                Arguments.of(new int[]{}, new int[]{}, 100),
                Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,3,4}, 4),
                Arguments.of(new int[]{0,0,0}, new int[]{0,0,0}, 1),
                Arguments.of(new int[]{9,7,6,3,8}, new int[]{3,8,9,7,6}, 3),
                Arguments.of(new int[]{7,6,3,8,9}, new int[]{9,7,6,3,8}, 4)
        );
    }
}