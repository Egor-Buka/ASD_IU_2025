package lab1.binarysearch.iterative;

import lab1.CustomArr;
import lab1.binarysearch.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchIterative {
    public static void main(String[] args) throws IOException {
        CustomArr arr = new CustomArr();
        arr.inputArray();
        arr.bubbleSort();
        BinarySearch.outputResult(binarySearch(arr.getArr(), BinarySearch.getTarget()), arr);
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
