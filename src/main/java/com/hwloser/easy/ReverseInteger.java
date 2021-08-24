package com.hwloser.easy;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();

        System.out.println(r.reverse_trash(-123));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }
        return res;
    }


    public int reverse_trash(int x) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        boolean isPositive = x < 0;
        x = Math.abs(x);

        while (x > 0) {
            stack.push(x % 10);
            x = x / 10;
        }

        while (!stack.empty()) {
            res = res * 10 + stack.pop();
        }

        return isPositive ? -res : res;
    }

}
