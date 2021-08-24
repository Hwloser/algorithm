package com.hwloser.medium;

import java.util.HashMap;

public class LongestSubstringWithAtLeaseKRepetingCharaters {
}

class Solution {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        int left, right;
        left = right = 0;

        HashMap<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {

        }
        return 0;
    }

    // 对于字符串 ss，如果存在某个字符 ch，
    // 它的出现次数大于 00 且小于 kk，
    // 则任何包含 ch 的子串都不可能满足要求。
    // 也就是说，我们将字符串按照 ch 切分成若干段，
    // 则满足要求的最长子串一定出现在某个被切分的段内，
    // 而不能跨越一个或多个段。
    // 因此，可以考虑分治的方式求解本题。
    public int longestSubstring1(String s, int k) {
        return 0;
    }

}
