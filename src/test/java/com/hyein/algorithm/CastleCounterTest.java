package com.hyein.algorithm;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CastleCounterTest {

    @Test
    public void test1(){
        int A[] = new int [] {2,2,3,4,3,3, 2, 2, 1, 1, 2, 5};
        assertEquals(4, CastleCounter.Solution(A));
    }

    @Test
    public void test2(){
        int A[] = new int [] {2};
        assertEquals(1, CastleCounter.Solution(A));
    }

    @Test
    public void test3(){
        int A[] = new int [] {-3, -3};
        assertEquals(1, CastleCounter.Solution(A));
    }

    @Test
    public void test4(){
        int A[] = new int [] {2, 2, 4};
        assertEquals(2, CastleCounter.Solution(A));
    }

    @Test
    public void test5(){
        int A[] = new int [] {2, 4, 4};
        assertEquals(2, CastleCounter.Solution(A));
    }

    @Test
    public void test6(){
        int A[] = new int [] {1, 2, 3, 4, 5};
        assertEquals(2, CastleCounter.Solution(A));
    }
}