package com.hwloser;

import java.util.Arrays;

public class MergeSort {

//  public static void main(String[] args) {
//    int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//    sort(arr);
//    System.out.println(Arrays.toString(arr));
//  }
//
//  public static void sort(int[] arr) {
//    int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
//    sort(arr, 0, arr.length - 1, temp);
//  }
//
//  private static void sort(int[] arr, int left, int right, int[] temp) {
//    if (left < right) {
//      int mid = (left + right) / 2;
//      sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
//      sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
//      merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
//    }
//  }

//  private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
//    int i = left;//左序列指针
//    int j = mid + 1;//右序列指针
//    int t = 0;//临时数组指针
//    while (i <= mid && j <= right) {
//      if (arr[i] <= arr[j]) {
//        temp[t++] = arr[i++];
//      } else {
//        temp[t++] = arr[j++];
//      }
//    }
//    while (i <= mid) {//将左边剩余元素填充进temp中
//      temp[t++] = arr[i++];
//    }
//    while (j <= right) {//将右序列剩余元素填充进temp中
//      temp[t++] = arr[j++];
//    }
//    t = 0;
//    //将temp中的元素全部拷贝到原数组中
//    while (left <= right) {
//      arr[left++] = temp[t++];
//    }
//  }

  public static void main(String[] args) {
    int[] testArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    mergeSort(testArray);
    System.out.println(Arrays.toString(testArray));
  }

  private static void mergeSort(int[] originArray) {
    int[] cache = new int[originArray.length];
    binarySort(originArray, 0, originArray.length - 1, cache);
  }

  private static void binarySort(int[] originArray, int left, int right, int[] cache) {
    if (left < right) {
      int mid = (left + right) / 2;
      binarySort(originArray, left, mid, cache);
      binarySort(originArray, mid + 1, right, cache);
      merge(originArray, left, mid, right, cache);
    }
  }


  private static void merge(int[] originArray, int left, int mid, int right, int[] cache) {
    int i = left; // array左半部份游标
    int j = mid + 1; // array右半部分游标

    // 游标
    int cursor = 0; // cache数组游标

    while (i <= mid && j <= right) {
      if (originArray[i] <= originArray[j]) {
        cache[cursor++] = originArray[i++];
      } else {
        cache[cursor++] = originArray[j++];
      }
    }

    while (i <= mid) { // 将左边剩余的元素填充到temp中
      cache[cursor++] = originArray[i++];
    }
    while (j <= right) { // 再将右边的元素填充仅temp中
      cache[cursor++] = originArray[j++];
    }

    // 待全部的元素填充完毕之后，将游标归零
    cursor = 0;

    while (left <= right) {
      originArray[left++] = cache[cursor++];
    }
  }
}
