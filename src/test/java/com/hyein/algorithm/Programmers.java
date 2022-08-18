package com.hyein.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class Programmers {

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43105
     */
    @Test
    public void test1(){
        System.out.println(solution1(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));


    }


    public int solution1(int[][] triangle) {

        int answer = triangle[0][0];
        int size = triangle.length;
        int [][] ar = new int[size][size];

        ar[0][0] = triangle[0][0];
        for(int i = 1; i < size; i ++){
            int max = 0;
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    ar[i][j] = ar[i-1][j] + triangle[i][j];
                } else if (i == j){
                    ar[i][j] = ar[i-1][j-1] + triangle[i][j];
                } else {
                    ar[i][j] = max(ar[i-1][j-1], ar[i-1][j]) + triangle[i][j];
                }

                if(max < ar[i][j])
                    max = ar[i][j];
            }
            answer=max;
        }

        return answer;
    }

    public int max(int a, int b){
        return a>b? a:b;
    }

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43165
     * 다항 연산
     */
    @Test
    public void test2(){
        System.out.println(recur(new int[]{1, 1, 1, 1, 1}, 0, 0, 3));
    }

    public int recur(int[] ar, int i, int sum, int target) {
        if(i==ar.length){
            if(sum == target)
                return 1;
            else
                return 0;
        }

        return recur(ar, i+1, target, sum+ar[i]) + recur(ar, i+1, target, sum-ar[i]);
    }


    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43163
     * 단어 변환 dfs
     */
    @Test
    public void test3(){
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
        System.out.println(solution("hit", "hot", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        // init visited
        boolean visited[] = new boolean[words.length];
        for (int i = 0, len = visited.length; i < len; i++)
            visited[i] = false;

        while(!queue.isEmpty()){
            Node cmp = queue.remove();
            for(int i = 0; i < words.length; i++){
                if(!visited[i]){

                    if(isSim(cmp.value, words[i])){
                        if(target.equals(words[i]))
                            return cmp.edge + 1;
                        else {
                            queue.add(new Node(words[i], cmp.edge+1));
                            visited[i] = true;
                        }
                    }
                }
            }
        }


        return 0;

    }

    private boolean isSim(String cmp, String word) {
        boolean diff = false;
        for(int i = 0; i < cmp.length(); i++){
            if(cmp.charAt(i) != word.charAt(i)){
                if(diff) return false;
                diff = true;
            }
        }

        return diff;
    }

    public class Node{
        String value;
        Integer edge;

        public Node(String value, Integer edge){
            this.value = value;
            this.edge = edge;
        }
    }


    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
     * 체육복
     */
    @Test
    public void test4(){
        System.out.println(solution4(5, new int[]{2, 4}, new int[]{5, 3, 1}));
        System.out.println(solution4(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution4(3, new int[]{3}, new int[]{1}));
        System.out.println(solution4(8, new int[]{5, 7}, new int[]{6, 8}));
        System.out.println(solution4(8, new int[]{5}, new int[]{5}));
        System.out.println(solution4(4, new int[]{1,2,3,4}, new int[]{1}));
        System.out.println(solution4(4, new int[]{2,3,4}, new int[]{1}));
        System.out.println(solution4(5, new int[]{2,3}, new int[]{3,4}));
    }

    // 풀인데 잘 한거
    public int solution4(int n, int lost[], int reserve[]) {
        int[] clothStatus = new int[n+1]; // 1부터 시작
        int ans = n;
        for(int i = 0; i < lost.length; i++){
            clothStatus[lost[i]]--;
        }

        for(int i = 0; i < reserve.length; i++){
            clothStatus[reserve[i]]++;
        }

        for(int i = 1; i <= n; i++){
            if(clothStatus[i] == -1){
                if(i>1 && clothStatus[i-1]==1){
                    clothStatus[i-1]--;
                    clothStatus[i]++;
                } else if(i < n && clothStatus[i+1]==1){
                    clothStatus[i+1]--;
                    clothStatus[i]++;
                } else {
                    ans--;
                }
            }
        }

        return ans;
    }

  /*  // 내가 한 건데 개느림
  public int solution4(int n, int lost[], int reserve[]) {
        Arrays.sort(lost);
        List<Integer> lostList = IntStream.of(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = IntStream.of(reserve).boxed().collect(Collectors.toList());

        int ans = n - lost.length;
        for(int i = 0; i < lostList.size(); i++){
            int value = lostList.get(i);
            if(reserveList.contains(value)){
                ans++;
                reserveList.remove(Integer.valueOf(value));
                continue;
            }

            if(value == 1 && !lostList.contains(1)){
                if(reserveList.contains(2)) {
                    ans++;
                    reserveList.remove(Integer.valueOf(2));
                    continue;
                }
            }

            if(value == n&& !lostList.contains(n-1)){
                if(reserveList.contains(n-1)){
                    ans++;
                    reserveList.remove(Integer.valueOf(n-1));
                    continue;
                }
            }

            if(reserveList.contains(value-1)&& !lostList.contains(value-1)){
                ans++;
                reserveList.remove(Integer.valueOf(value-1));
                continue;
            }
            if(reserveList.contains(value+1)&& !lostList.contains(value+1)){
                ans++;
                reserveList.remove(Integer.valueOf(value+1));
                continue;
            }

        }

        return ans;
    }*/


    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42576
     * 완주 못 한 선수
     */
    @Test
    public void test5(){
        System.out.println(solution5(new String[]{"leo", "kiki", "eden"}, new String[]{"kiki", "eden"}));
        System.out.println(solution5(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"marina", "josipa", "nikola", "filipa"}));
        System.out.println(solution5(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"mislav", "stanko", "ana"}));
    }

    public String solution5(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 더 빠른 거
        for(String p: participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c: completion){
            map.put(c, map.get(c) - 1);
        }

        /*
        // 내가 한 거
        for(String p: participant){
            if(map.computeIfPresent(p, (String key, Integer value) -> ++value) == null){
                map.put(p, 1);
            }
        }

        for(String c: completion){
            map.computeIfPresent(c, (String key, Integer value) -> --value);
        }*/

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() != 0)
                return entry.getKey();
        }



        return "";
    }

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42577
     * 전화번호 목록
     */
    @Test
    public void test6(){
        System.out.println(solution5(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution5(new String[]{"123", "456", "789"}));
        System.out.println(solution5(new String[]{"12", "123", "1235", "567", "88"}));
    }

    public boolean solution5(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(String val: phone_book){
            int valSize = val.length();
            if(map.isEmpty()){
                map.put(val, valSize);
                continue;
            }


            for(Map.Entry<String, Integer> entry: map.entrySet()){
                System.out.println(entry.getKey());

                if(valSize < entry.getValue()){
                    if(entry.getKey().matches("^"+val+".*"))
                        return false;
                    else
                        map.put(val, valSize);
                } else {
                    if(val.matches("^"+entry.getKey()+".*"))
                        return false;
                    else
                        map.put(val, valSize);
                }
            }
        }
        return true;
    }

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42578
     * 위장
     */
    @Test
    public void test7(){
        System.out.println(solution7(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution7(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
        System.out.println(solution7(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}, {"A", "eye"}, {"B", "arm"}}));
        System.out.println(solution7(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}, {"A", "eye"},  {"A", "eye"},{"B", "arm"}}));
    }

    public int solution7(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        List<Integer> fac = new ArrayList<>();

        for(String[] values: clothes){
            map.put(values[1], map.getOrDefault(values[1], 0) + 1);
            answer++;
        }


        int n = map.size();
        for(int i = 2; i <= n; i++){

            int t = permutation(fac, n, i);
            for(Map.Entry<String, Integer> entry: map.entrySet()){
                t *= entry.getValue();
            }
            answer += t;
        }

        return answer;
    }

    private int permutation(List<Integer> fac, int n, int i) {
        int t = n-i==0? 1: n-i;
        return fact(fac, n) /  fact(fac, t) /  fact(fac, i);
    }

    private int fact(List<Integer> fac, int n) {
        if(n<=fac.size())
            return fac.get(n-1);

        int k = fac.size();
        while(k < n){
            if(k == 0)
                fac.add(1);
            else
                fac.add(fac.get(k-1) * (k+1));
            k++;
        }
        return fac.get(n-1);
    }



    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42579
     * 베스트앨범
     */
    @Test
    public void test8(){
        System.out.println(Arrays.toString(solution8(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
        System.out.println(Arrays.toString(solution8(new String[]{"pop", "pop", "classic", "classic", "classic" }, new int[]{2500, 600, 150, 500, 500})));
        System.out.println(Arrays.toString(solution8(new String[]{"classic", "pop", "classic" ,"pop", "classic", "classic" }, new int[]{400, 600, 150, 2500, 500, 500})));
        System.out.println(Arrays.toString(solution8(new String[]{"pop"}, new int[]{400})));
        System.out.println(Arrays.toString(solution8(new String[]{"pop", "classic"}, new int[]{400, 500})));
        System.out.println(Arrays.toString(solution8(new String[]{"pop", "pop"}, new int[]{400, 3})));
        System.out.println(Arrays.toString(solution8(new String[]{"pop", "pop", "pop"}, new int[]{3, 1, 400})));
        System.out.println(Arrays.toString(solution8(new String[]{"classic", "pop", "classic", "classic", "pop", "A", "B"}, new int[]{500, 600, 150, 800, 2500, 1, 10})));
        System.out.println(Arrays.toString(solution8(new String[]{"classic", "pop", "classic", "classic", "pop", "A"}, new int[]{500, 600, 150, 800, 2500, 1})));
        System.out.println(Arrays.toString(solution8(new String[]{"a", "b", "c", "d", "e", "f"}, new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(solution8(new String[]{"a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f"}, new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(solution8(new String[]{"pop", "pop", "pop"}, new int[]{1, 1, 1})));
        System.out.println(Arrays.toString(solution8(new String[]{"pop", "pop"}, new int[]{3, 4})));
        System.out.println(Arrays.toString(solution8(new String[]{"a", "a", "b", "c", "a", "a"}, new int[]{1, 2, 2, 2, 2, 2})));
        System.out.println(Arrays.toString(solution8(new String[]{"a", "a", "d", "d", "c", "b"}, new int[]{5, 5, 3, 3, 500, 6})));

    }

    public int[] solution8(String[] genres, int[] plays) {
        int n = genres.length;
        List<Integer> answer = new ArrayList<>();

        Map<String, Queue> map = new HashMap<>();
        // plays 정렬
        for(int i = 0; i < n; i++){
            String key = genres[i];
            log.info("{}: {}", key, plays[i]);

            Queue playsQueue = map.computeIfAbsent(key, k -> new PriorityQueue<Integer>(Comparator.comparingInt(idx -> plays[(int) idx])));

//            Queue playsQueue = map.computeIfAbsent(key, k -> new PriorityQueue<Integer>(Comparator.comparingInt(idx -> plays[(int) idx])));
//            Queue playsQueue = map.computeIfAbsent(key, k -> new PriorityQueue<Integer>(Comparator.comparingInt(idx -> plays[(int) idx]).reversed()));
            playsQueue.add(i);

        }
        log.info(map.toString());
        // genre 정렬
        Queue<Queue<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt((q) -> plays[((Queue<Integer>)q).peek()]).reversed());
        map.values().forEach(v -> {queue.add(v);});

        while(!queue.isEmpty()){
            Queue<Integer> outsideQ = queue.poll();

            answer.add(outsideQ.poll());

            if(outsideQ.peek() != null)
                answer.add(outsideQ.poll());
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }


    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43164
     * 여행경로
     */
    @Test
    public void test9(){
        System.out.println(Arrays.toString(solution9(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution9(new String[][]{{"ICN", "B"}, {"ICN", "C"}, {"C", "D"}, {"D", "ICN"}})));

    }

    public String[] solution9(String[][] tickets) {
        int n = tickets.length;
        List<String> answer = new ArrayList<>();
        boolean[] visited = new boolean[n];

        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));

        dfs("ICN", tickets, visited, answer);
        answer.add("ICN");

        Collections.reverse(answer);
        return answer.toArray(new String[n + 1]);
    }

    public boolean dfs(String from, String[][] tickets, boolean[] visited, List<String> answer){
        int n = tickets.length;
        for(int i = 0; i < n; i++){

            if(!visited[i] && tickets[i][0].equals(from)){
                String to = tickets[i][1];
                visited[i] = true;
                boolean successed = dfs(to, tickets, visited, answer);
                if(successed){
                    answer.add(to);
                    return true;
                } else {
                    visited[i] = false;
                }


            }

        }


        for(int i = 0 ; i < n; i++){
            if(!visited[i])
                return false;
        }

        return true;
    }



}
