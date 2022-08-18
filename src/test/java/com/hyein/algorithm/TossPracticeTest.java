package com.hyein.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TossPracticeTest {
    @Test
    public void test1(){
//        assertEquals();
        solution1("11");
    }

    public void solution1(String input) {
        String other = input.replace("1", "").replace("2", "");
        if(!other.isEmpty())
            System.out.println("false");
        else if(input.replace("12", "").contains("1"))
            System.out.println("false");
        else
            System.out.println("true");

    }

    @Test
    public void test2(){
            solution2("1 2 3 4 5 35");
    }

    public void solution2(String input) {
        String[] s = input.split(" ");
        if(s.length != 6){
            System.out.println("false");
            return;
        }
        Set<String> integers = new HashSet<>(Arrays.asList(s));
        if(integers.size() != 6){
            System.out.println("false");
            return;
        }

        int before = 0;
        for(int i = 0; i < s.length; i++){
            int i1 = Integer.parseInt(s[i]);
            System.out.println(i1);
            if(i1 < 1 || i1 > 45 ){
                System.out.println("false");
                return;
            }

            if(i!=0){
                if(before > i1){
                    System.out.println("false");
                    return;
                }
            }
            before = i1;
        }

            System.out.println("true");

    }

    @Test
    public void test3(){
        solution3("1");
//        assertEquals();
    }

    public void solution3(String input) {
        String[] s = input.split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length; i++) {
            int i1 = Integer.parseInt(s[i]);

            if(!map.containsKey(i1)) {
                map.put(i1, i1);
            }
            System.out.print(map.get(i1));

            if(i != s.length - 1)
                System.out.print(" ");

        }


    }

    @Test
    public void test4(){
        solution4("우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축");
    }

    public void solution4(String input) {
        String[] s = input.split(" ");
        for(int i = 0; i < s.length; i ++){
            Set<String> set = new LinkedHashSet<>();
            int k = i;

            while(set.size() < 5){
                set.add(s[k--]);
                if(k == -1)
                    break;
            }

            for(String an: set){
                System.out.print(an + " ");
            }
            System.out.println();
        }


    }

    @Test
    public void test5(){
//        assertEquals();
        solution5("100 300 10 0 40 0 0 70 65", "40 300 20 10 10 20 100 10 0");
    }

    public void solution5(String input1, String input2) {
        String[] s1 = input1.split(" ");
        String[] s2 = input2.split(" ");

        int giveMe = 0;
        for(int i = 0; i < s1.length; i++){
            int i1 = Integer.parseInt(s1[i]);
            int i2 = Integer.parseInt(s2[i]);

            giveMe += i1;
            giveMe -= i2;

            if(giveMe > 0){
                System.out.print(giveMe + " ");
                giveMe = 0;
            } else {
                System.out.print("0" + " ");

            }

        }


    }

    @Test
    public void test6(){
//        assertEquals();
    }

    public void solution6(String number) {

    }

    @Test
    public void test7(){
//        assertEquals();
    }

    public void solution7(String number, int k) {

    }
}
