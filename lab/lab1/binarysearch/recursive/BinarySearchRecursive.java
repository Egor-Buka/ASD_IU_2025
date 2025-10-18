package lab1.binarysearch.recursive;

import lab1.CustomArr;
import lab1.binarysearch.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchRecursive {
    public static void main(String[] args) throws IOException {
        CustomArr arr = new CustomArr();
        arr.inputArray();
        arr.bubbleSort();
        BinarySearch.outputResult(binarySearch(arr.getArr(), BinarySearch.getTarget(), 0, arr.getLen()), arr);
    }

    public static int binarySearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (key < arr[mid]) {
            return binarySearch(arr, key, left, mid + 1);
        } else {
            return binarySearch(arr, key, mid + 1, right);
        }
    }
}
