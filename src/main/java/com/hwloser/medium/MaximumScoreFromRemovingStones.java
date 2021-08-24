package com.hwloser.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        if (a + b <= c)
            return a + b;
        else if (a + c <= b)
            return a + c;
        else if (b + c <= a)
            return b + c;
        return (a + b + c) / 2;
    }

    public int maximumScore_2(int a, int b, int c) {
        int default_initial_capacity = 11;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(default_initial_capacity, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.add(a);
        queue.add(b);
        queue.add(c);

        int res = 0;

        while (true) {
            int maxNum = queue.remove();
            int secNum = queue.remove();

            if (secNum < 0) {
                break;
            }

            queue.add(maxNum - 1);
            queue.add(secNum - 1);
            res += 1;
        }

        return res;
    }
}
