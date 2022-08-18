package com.hyein.algorithm;

import java.util.Stack;

public class FindFuzzyWord extends CastleCounter{
    @Override
    void as() {
        super.as();
    }

    @Override
    protected void ss() {

    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
//        answer = dfs(begin, target, words, visited);
//        return answer;
        return dfs(begin, target, words, visited, 1, 0);
    }

    private static int dfs(String begin, String target, String[] words, boolean[] visited, int count, int max) {
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && isFuzzy(begin, words[i])){
                visited[i] = true;
                if(words[i].equals(target)){
                    max = max > count? max : count;
                    return max;
                }
                else {
                    return dfs(words[i], target, words, visited, count + 1, max);
//                    return  res != 0? res+1 : 0;
                }

            }
            Stack<Integer> a = new Stack<>();
        }
        return max;
    }

    private static boolean isFuzzy(String begin, String word) {
        int diffChars = 0;
        for (int i = 0; i < begin.length(); i++){
            if (begin.charAt(i) != word.charAt(i))
                diffChars ++;
        }

        return diffChars == 1;
    }


}
