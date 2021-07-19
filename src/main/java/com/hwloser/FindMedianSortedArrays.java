package com.hwloser;

public class FindMedianSortedArrays {

  public static void main(String[] args) {
//    int[] nums1 = {1, 3}, nums2 = {2};
    int[] nums1 = {1, 2}, nums2 = {3, 4};

    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    return m1(nums1, nums2);
  }

  /**
   * O(m+n)
   */
  private static double m1(int[] nums1, int[] nums2) {
    int n = nums1.length,
        m = nums2.length;

    int[] temp = new int[n + m];

    int i = 0, j = 0;
    int cursor = 0;

    while (cursor < temp.length && (i < n && j < m)) {
      if (nums1[i] <= nums2[j]) {
        temp[cursor++] = nums1[i++];
      } else {
        temp[cursor++] = nums2[j++];
      }
    }

    while (i < n) {
      temp[cursor++] = nums1[i++];
    }

    while (j < m) {
      temp[cursor++] = nums2[j++];
    }

    if (temp.length == 0) {
      return 0;
    } else if (temp.length % 2 == 0) {
      int tl = temp.length / 2 - 1;
      return (double) (temp[tl] + temp[tl + 1]) / 2;
    } else {
      return temp[temp.length / 2];
    }
  }

  /**
   * O(log(m+n))
   */
  private static double m2(int[] nums1, int[] nums2) {
    return 0;
  }

  private int getKthElement(int[] nums1, int[] nums2, int k) {

    int length1 = nums1.length,
        length2 = nums2.length;
    // cursor for nums1 and nums2
    int index1 = 0,
        index2 = 0;

    // the kth element placeholder
    int kthElement = 0;

    while (true) {

      int mid = k / 2;
      int newIndex1 = Math.min(index1 + mid, length1) - 1;
      int newIndex2 = Math.min(index2 + mid, length2) - 1;

      int pivot1 = nums1[newIndex1],
          pivot2 = nums2[newIndex2];

      if (pivot1 <= pivot2) {
        k -= (newIndex1 - index1 + 1);
        index1 = newIndex1 + 1;
      } else {
        k -= (newIndex2 - index2 + 1);
        index2 = newIndex2 + 1;
      }

    }

  }
}
