package com.hyein.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class KakaoTest {


    @Test
    public void test2(){
        solution(new int[]{3, 7, 2, 5, 4, 6, 8, 9, 10}, 3);
        solution(new int[]{1, 2, 3, 1, 2}, 1);
        solution(new int[]{1,1, 1}, 1);
        solution(new int[]{2, 5, 4, 6, 8}, 3);
        solution(new int[]{1, 1000000000}, 1);
    }

    public void solution(int[] space, int segment) {
        int n = space.length, max = 0;
        MinHeap minHeap = new MinHeap(segment+1);

        for(int i = 0; i < n; i++){
            if(segment <= i)
                minHeap.switchh(space[i-segment], space[i]);
            else
                minHeap.add(space[i]);
//            System.out.println(Arrays.toString(minHeap.heap));

            if(segment <= i){
                int min = minHeap.getMin();
                if(max < min)
                    max = min;
            }
        }

        System.out.println(max);
    }

    public class MinHeap {
        int[] heap; // start from index 1
        int heapSize;

        public MinHeap(int size){
            heap = new int[size];
            heapSize = 0;
        }

        public void add(int value) {
            heapSize += 1;
            heap[heapSize] = value;

            sort(heapSize);

        }

        private void sort(int idx) {
            if(idx == 1)
                return;

            int parentIdx = idx / 2;
            // 자식 값이 부모값보다 크면 switch
            if(heap[idx] < heap[parentIdx]) {
                // switch
                int tmp = heap[idx];
                heap[idx] = heap[parentIdx];
                heap[parentIdx] = tmp;

                sort(parentIdx);
            }
        }

        public void switchh(int oldValue, int newValue) {
            for(int i = 1; i <= heapSize; i++)
                if(heap[i] == oldValue){
                    heap[i] = newValue;
                    sort(heapSize);
                }

        }

        public int getMin() {
            return heap[1];
        }
    }

}
