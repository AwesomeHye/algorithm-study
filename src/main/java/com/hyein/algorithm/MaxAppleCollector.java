package com.hyein.algorithm;

/**
 * [QUESTION]
 * Alice and Bob work in a beautiful orchard.
 * There are N  apple trees in the orchard.
 * The apple trees are arranged in a row and they are numbered from 1 to N.
 * Alice is planning to collect all the apples from K consecutive trees and Bob is planning to collect all the apples from L consecutive trees.
 * They want to choose two disjoint segments (one consisting of K trees for Alice and the other consisting of L trees for Bob) so as not to disturb each other.
 * What is the maximum number of apples that they can collect? Write a function that, given an array A consisting of N integers denoting the number of apples on each apple tree in the row, and integers K and L denoting, respectively, the number of trees that Alice and Bob can choose when collecting, returns the maximum number of apples that can be collected by them, or −1 if there are no such intervals.
 * For example, given A = [6, 1, 4, 6, 3, 2, 7, 4], K = 3, L = 2, your function should return 24, because Alice can choose trees 3 to 5 and collect 4 + 6 + 3 = 13 apples, and Bob can choose trees 7 to 8 and collect 7 + 4 = 11 apples.
 * Thus, they will collect 13 + 11 = 24 apples in total, and that is the maximum number that can be achieved.
 * Given A = [10, 19, 15], K = 2, L = 2, your function should return −1, because it is not possible for Alice and Bob to choose two disjoint intervals.
 */
public class MaxAppleCollector {

    static int getMaxCollectedApples(int[] trees, int t, int u){
        int maxAppleCount = 0;

        int treeCount = trees.length;

        // 둘이 합친 나무 수가 초과하면 -1 반환
        if (t + u > treeCount) {
            return -1;
        }

        for(int begin = 0; begin < treeCount; begin++){
            // t가 고를 나무 인덱스가 초과되면 종료
            if(begin + (t-1) >= treeCount)
                break;

            // t가 고른 나무를 지정할 플래그
            int[] isAdded = new int[treeCount];

            // t 의 연속된 AppleCount 값 부터 구하기
            int tAppleCount = 0;
            for(int tCount = 0; tCount < t; tCount++){
                int addedIdx = begin + tCount;
                isAdded[addedIdx] = 1;
                tAppleCount += trees[addedIdx];
            }

            // t 가 안고를 나무들 중 u개의 연속되는 나무들이 존재하면 더하기
            int uAppleCount = 0;
            out:
            for(int chkIdx = 0; chkIdx < treeCount; chkIdx++) {
                // u가 고를 나무 인덱스가 초과되면 종료
                if(chkIdx + u > treeCount)
                    break;

                // u가 고를 첫 나무가 이미 t가 고른 나무면 현재 사이클 종료
                if(trees[chkIdx] == 1)
                    continue;

                // 이제 u 의 연속된 AppleCount 값 구하기
                for (int uCount = 0; uCount < u; uCount++) {
                    int addedIdx = chkIdx + uCount;
                    // 연속된 나무 인덱스 중간에 하나라도 t가 딴 나무 있으면 현재 사이클 종료
                    if (isAdded[addedIdx] == 1){
                        uAppleCount = 0;
                        continue out;
                    }
                    uAppleCount += trees[addedIdx];
                }

                // 지금 딴 t + u의 사과 수랑 기존에 딴 사과 수랑 비교
                int currentSum = tAppleCount + uAppleCount;
                if(currentSum > maxAppleCount)
                    maxAppleCount = currentSum;

                uAppleCount = 0;
            }
        }

        return maxAppleCount;
    }
}
