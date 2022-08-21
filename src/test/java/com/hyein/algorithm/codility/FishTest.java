package com.hyein.algorithm.codility;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FishTest {

    @ParameterizedTest
    @MethodSource
    public void test(int ans, int[] A, int[] B) {
        assertAll(() -> {
            assertEquals(ans, Fish.solution(A, B));

        });
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(1, new int[]{6,3,2,1,7}, new int[]{1,0,0,0,0}),
                Arguments.of(4, new int[]{2,1,3,4,5}, new int[]{0,0,1,0,0})
        );
    }
}