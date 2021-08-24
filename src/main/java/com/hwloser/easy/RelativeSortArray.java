package com.hwloser.easy;

import java.util.*;
import java.util.stream.Collectors;

public class RelativeSortArray {
    public static void main(String[] args) {
//        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
//        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] arr1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] arr2 = {2, 42, 38, 0, 43, 21};
        for (int i : new RelativeSortArray().relativeSortArray(arr1, arr2)) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
    // force
    // fail 失败
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length];
        HashSet<Integer> set = new HashSet<Integer>(arr2.length);
        for (int i : arr2) {
            set.add(i);
        }
        int cursor = 0;
        for (int item : arr2) {
            for (int itmeArr1 : arr1) {
                if (item == itmeArr1) {
                    temp[cursor] = itmeArr1;
                    cursor++;
                }
            }
        }
        int start = cursor;
        for (int value : arr1) {
            int t;
            if (!set.contains(t = value)) {
                for (int i = cursor; cursor >= i; i++) {
                    if (t <= temp[cursor]) {
                        temp[cursor + 1] = t;
                        temp[cursor++] = t;
                    } else {
                        temp[cursor++] = t;
                    }
                }

            }
        }
        return temp;
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length];
        int cursor = 0;
        HashMap<Integer, Integer> index = new HashMap();
        for (int value : arr1) {
            index.compute(value, (k, v) -> {
                if (null == v) {
                    return 1;
                }
                return v + 1;
            });
        }
        for (int i : arr2) {
            if (index.containsKey(i)) {
                for (int j = 0; j < index.get(i); j++) {
                    temp[cursor++] = i;
                }
                index.remove(i);
            }
        }
        List<Integer> keys = index.keySet().stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
        for (int i : keys) {
            for (int j = 0; j < index.get(i); j++) {
                temp[cursor++] = i;
            }
            index.remove(i);
        }
        return temp;
    }
}
