package doitStudy.sortingAlgorithm.radixSort;

import java.io.*;
import java.util.*;


public class RadixSortExam {
// Radix sort Java implementation

    // Main driver method
    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        // exp = 현재 자릿수
        for (int exp = 1; m / exp > 0; exp *= 10) {
            // 각 자릿수에 대한 countSort() 호출
            countSort(arr, n, exp);
        }
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n) { // 배열안에서 최댓값 뽑기
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) //arr[i]가 셋팅되어 있는 변수 mx보다 크다면 mx변수에 arr[i]값으로 변경
                mx = arr[i];
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp) { // 현재 자리수에 나타난 숫자에 따라 배열의 countion sort 하는 함수
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        /*
            Arrays.fill(int[], int);
            지정된 int[]의 모든 요소에 지정한 int값을 할당한다.
         */

        for (i = 0; i < n; i++) { //count[]에 arr[]의 각 요소들의 exp자리수에 대한 개수 저장
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) { // count된 숫자들에 대한 합배열인뎅
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

}