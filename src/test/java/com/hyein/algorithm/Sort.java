package com.hyein.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Sort {
    @Test
    public void quickSortTest(){
        System.out.println(Arrays.toString(quickSort(new int[]{5, 1, 2, 6, 3, 2}, 0, 5)));
        System.out.println(Arrays.toString(quickSort(new int[]{1, 1, 2, 1, 1, 100}, 0, 5)));
    }
    public int[] quickSort(int[] ar, int left, int right){
        if(left >= right)
            return ar;

        int l = left+1, r = right, pivot = ar[left];

        while(l < r) {
            while (l < r && ar[r] >= pivot) {
                r--;
            }

            while (l < r && ar[l] <= pivot) {
                l++;
            }

            if (l < r) {
                int tmp = ar[l];
                ar[l] = ar[r];
                ar[r] = tmp;
            }

        }

        ar[left] = ar[l];
        ar[l] = pivot;

        quickSort(ar, left, l-1);
        quickSort(ar, r+1, right);


        return ar;
    }

    @Test
    public void mergeSortTest(){
        System.out.println(Arrays.toString(mergeSort(new int[]{5, 1, 2, 6, 3, 2}, 0, 5)));
        System.out.println(Arrays.toString(mergeSort(new int[]{1, 1, 2, 1, 1, 100},  0, 5)));
    }
    public int[] mergeSort(int[] ar, int left, int right){
        if(left >= right)
            return ar;

        int middle = (left + right) / 2;

        mergeSort(ar, left, middle);
        mergeSort(ar, middle+1, right);
        merge(ar, left, middle, right);
//        System.out.println(Arrays.toString(ar));

        return ar;
    }

    private void merge(int[] ar, int left, int middle, int right) {
        int nr[] = new int[right-left+1];
        int k = 0, l = left,  r = middle+1;


        // 왼쪽 loop
//        for(int i = left; i <= middle;){
         while (l <= middle){
            if((r > right) || (r <= right && ar[l] < ar[r]) ){
                // 왼쪽배열이 작거나 오른쪽배열이 다 넣어졌으면 왼쪽 넣기
                nr[k++] = ar[l++];
            } else{
                //오른쪽 아직 있고 오른쪽이 더 작으면
                nr[k++] = ar[r++];
            }


        }

        // 오른쪽 남아있으면 다 넣기
        while (r <= right){
            nr[k++] = ar[r++];
        }


        // 원배열에 대입
        k = 0;
        for(int i = left; i <= right; i++){
            ar[i] = nr[k++];
        }


    }
}
