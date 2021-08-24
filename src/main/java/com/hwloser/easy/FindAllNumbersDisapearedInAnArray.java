package com.hwloser.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisapearedInAnArray {
    public static void main(String[] args) {

    }
    public int maximumScore(int a, int b, int c) {
        int count = 0;

        int[] t = {a, b, c};
        Arrays.sort(t);

        boolean judge = t[0] != 0 && t[1] != 0 && t[2] != 0;

        while (judge) {
            if (t[0] != 0) {
                t[0] = t[0] - 1;
                t[2] = t[2] - 1;
            } else {
                t[1] = t[1] - 1;
                t[2] = t[2] - 1;
            }
            count += 1;
        }
        return count;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) res.add(i);
        }
        return res;
    }

    // 数组的原地操作
    /**
     * index = nums[i] (i = 0..nums.length)
     * 将 nums[index]的位置标记为 负数。未标记过的 则代表在nums中未出现索引数字
     */
    public List<Integer> findDisappearedNumbers_2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = nums[i];
            int temp = nums[index - 1] * -1;

            if (temp < 0) {
                nums[index - 1] = temp;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
