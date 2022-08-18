package com.hyein.algorithm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class FindFuzzyWordTest {

    @ParameterizedTest
    @MethodSource
    void solution(String begin, String target, String[] words, int res) {
        assertEquals(res, FindFuzzyWord.solution(begin, target, words));
    }

    private static Stream solution(){
        return Stream.of(
//                Arguments.of("hit", "cog", new String[]{"cit", "cot", "cog"}, 3)
//                Arguments.of("hit", "cog", new String[]{"cit", "cot", "coz"}, 0),
//                Arguments.of("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}, 0),
                Arguments.of("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}, 4)

        );
    }
}