package com.hwloser.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {

    }

    // hashSet
    public int singleNumber(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list.size() > 0 ? list.get(0) : 0;
    }

    // hashMap
    public int singleNumber_2(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.size() > 0 ? list.get(0) : 0;
    }

    public int singleNumber_3(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();

        int arrSum = 0;
        for (int num : nums) {
            set.add(num);
            arrSum += num;
        }

        int setSum = 0;
        for (Integer i : set) {
            setSum += i;
        }

        return setSum * 2 - arrSum;
    }

    /**
     * 异或运算的特性：
     *   1. 任何数和0做异或运算，结果任然是原来的数，即 a⊕0=a；
     *   2. 任何数和其自身做异或运算，结果是0，即 a⊕a=0;
     *   3. 异或运算满足交换律和结合律，即 a⊕b⊕b = b⊕a⊕a = b⊕(a⊕a) = b⊕0 = b
     */
    public int singleNumber_4(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
