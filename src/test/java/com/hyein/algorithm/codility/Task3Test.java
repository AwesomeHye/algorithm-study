package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Task3Test {

    @ParameterizedTest
    @MethodSource
    public void test(int ans, int[] A) {
        assertAll(() -> {
            assertEquals(ans, Task3.solution(A));

        });
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(1, new int[]{6,3,2,1,7}),
                Arguments.of(1, new int[]{2,1,3,4,5})
        );
    }
}