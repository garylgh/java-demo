package com.ghlin.algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,2,3,7,9,1,5,8};
        quickSort(arr, 0, 8);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            arr[left] = arr[right];

            while (arr[left] <= pivot && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
