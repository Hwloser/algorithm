package com.hwloser;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
    ;
  }

  /**
   * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
   */
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> cache = new HashSet<Character>();

    int n = s.length();

    // 右边指针
    int rk = -1, ans = 0;
    return 0;
  }
}
