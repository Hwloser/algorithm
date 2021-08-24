package com.hwloser;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));

    System.out.println("l2 : " + l2(s));

  }

  /**
   * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
   */
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> occ = new HashSet<Character>();

    // string length
    int n = s.length();

    // 右边指针
    int rk = -1, ans = 0;
    for (int lc = 0; lc < n; lc++) {
      if (lc != 0) {
        // The left pointer moves one digit to the right, removing one character
        occ.remove(s.charAt(lc - 1));
      }

      while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
        occ.add(s.charAt(rk + 1));
        ++rk;
      }

      ans = Math.max(ans, rk - lc + 1);
    }
    return ans;
  }

  public static int l2(String s) {
    HashSet<Character> occ = new HashSet<Character>();

    int n = s.length();

    int rc = -1, ans = 0;
    for (int lc = 0; lc < n; ++lc) {
      if (lc != 0) {
        occ.remove(s.charAt(lc - 1));
      }

      for (; rc + 1 < n && !occ.contains(s.charAt(rc + 1)); rc++) {
        // 只要不重复， -- !occ.contains(s.charAt(rc + 1))
        // 就不断地向右移动  -- rc++
        // 直至移动到末端 -- （rc + 1 < n）
        occ.add(s.charAt(rc + 1));
      }

      // 从 lc 到 rc个字符（rc - lc + 1）是一个无重复字符子串
      ans = Math.max(ans, rc - lc + 1);
    }

    return ans;
  }

}
