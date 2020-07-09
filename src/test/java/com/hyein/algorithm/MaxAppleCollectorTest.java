package com.hyein.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAppleCollectorTest {

    @Test
    public void test1(){
        int[] trees = {6, 1, 4, 6, 3, 2, 7, 4};
        int t = 2;
        int u = 3;

        assertEquals(24, MaxAppleCollector.getMaxCollectedApples(trees, t, u));
    }

    @Test
    public void test4(){
        int[] trees = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        int t = 3;
        int u = 2;

        assertEquals(17, MaxAppleCollector.getMaxCollectedApples(trees, t, u));
    }

    @Test
    public void test2(){
        int[] trees = {1, 2, 3, 4};
        int t = 2;
        int u = 2;

        assertEquals(10, MaxAppleCollector.getMaxCollectedApples(trees, t, u));
    }

    @Test
    public void test3(){
        int[] trees = {10, 19, 15};
        int t = 2;
        int u = 2;

        assertEquals(-1, MaxAppleCollector.getMaxCollectedApples(trees, t, u));
    }


}