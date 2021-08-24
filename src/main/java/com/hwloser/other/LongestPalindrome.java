package com.hwloser;

public class LongestPalindrome {
  public static void main(String[] args) {
    LongestPalindrome a = new LongestPalindrome();

    System.out.println(a.longestPalindrome("babad"));
  }

  /**
   * dynamic programme resolve
   */
  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }

    int maxLength = 1;
    int beginIndex = 0;

    // dp[i][j]表示 s{i..j} 是否为回文子串
    boolean[][] dp = new boolean[len][len];

    // initial dp array
    for (int i = 0; i < len; i++) {
      // 所有长度为1的子串都是回文子串
      dp[i][i] = true;
    }

    // 索引字符串数组
    char[] chars = s.toCharArray();

    // 枚举`回文子串`的长度【L】
    // L是回文的长度, 最长为n
    for (int L = 2; L <= len; L++) {
      // 迭代 `回文子串` 的左边界，i是回文的左边界的索引
      // j - i + 1 == L
      for (int i = 0; i < len; i++) {
        // j是右边界的索引
        int j = L + i - 1;

        // 如果右边界越界，就可以退出当前循环
        if (j >= len) {
          break;
        }

        if (chars[i] != chars[j]) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
        // 只要 dp[i][j] == true，
        // 那么 就表示 s[i..j] 是回文，此时记录回文长度和起始位置
        if (dp[i][j] && j - i + 1 > maxLength) {
          maxLength = j - i + 1;
          beginIndex = i;
        }
      }
    }

    return s.substring(beginIndex, beginIndex + maxLength);
  }

  private String m1(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }

    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++) {
      int l1 = extendAroundCenter(s, i, i);
      int l2 = extendAroundCenter(s, i, i + 1);

      int len = Math.max(l1, l2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private int extendAroundCenter(String s, int left, int right) {
    while (left >= 0 &&
        right < s.length() &&
        s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
