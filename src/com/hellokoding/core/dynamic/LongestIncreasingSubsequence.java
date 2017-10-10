package com.hellokoding.core.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
     int findLengthOfLIS(int[] arr) {
        int N = arr.length;
        int[] lis = new int[N];

        for (int i = 0; i < N; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (lis[i] < lis[j] + 1)) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = lis[0];
        for (int i = 1; i < N; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
     }

     int[] findLIS(int[] arr) {
         List<List<Integer>> lis = new ArrayList<>();

         for (int i = 0; i < arr.length; i++) {
             lis.add(new ArrayList<>());
         }

         lis.get(0).add(arr[0]);

         for (int i = 1; i < arr.length; i++) {
             for (int j = 0; j < i; j++) {
                 if (arr[i] > arr[j] && lis.get(i).size() < lis.get(j).size() + 1) {
                     lis.set(i, new ArrayList<>(lis.get(j)));
                 }
             }
             lis.get(i).add(arr[i]);
         }

         List<Integer> longest = lis.get(0);
         for (int i = 0; i < lis.size(); i++) {
            if (longest.size() < lis.get(i).size()) {
                longest = new ArrayList<>(lis.get(i));
            }
         }

         return longest.stream().mapToInt(i->i).toArray();
     }

    public static void main(String[] args) {
        int arr[] = {3, 2, 6, 4, 5, 1};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println("Length of LIS: " + lis.findLengthOfLIS(arr));
        System.out.println("LIS: " + Arrays.toString(lis.findLIS(arr)));
    }
}
