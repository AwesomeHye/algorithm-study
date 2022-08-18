package com.hyein.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiscTest {
    /**
     * n 이하 수 중 2의 거듭제공을 만족하는 가장 큰 수 반환
     */
    @Test
    public void main1() {
        assertEquals(1024, sol1(1024));
        assertEquals(67108864, sol1(97615282));
        assertEquals(4, sol1(5));
    }

    public int sol1(int n) {
        int val = 1;
        while (2 * val <= n) {
            val *= 2;
        }

        return val;
    }
    /*public int sol1(int n){
        for(int i = n ; i > 1; i--){
            if(re(i))
                return i;
        }

        return 0;
    }

    private boolean re(int i) {
        if(i % 2 != 0)
            return false;
        if(i / 2 == 1)
            return true;

        return re(i/2);
    }*/


    @Test
    public void main2() {
        System.out.println(timeConversion("07:05:45PM"));
        System.out.println(timeConversion("12:40:22AM"));
    }

    String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int hour = Integer.valueOf(s.substring(0, 2));
        char time = s.charAt(s.length() - 2);
        if ((hour != 12 && time == 'P'))
            return (hour + 12) + s.substring(2, s.length() - 2);
        else if (hour == 12 && time == 'A')
            return "00" + s.substring(2, s.length() - 2);
        else
            return s.substring(0, s.length() - 2);

    }


    @Test
    public void main3() {
        List<List<String>> arr = new ArrayList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

    }

}
