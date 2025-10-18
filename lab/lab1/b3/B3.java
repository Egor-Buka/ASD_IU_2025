/*Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
число, которое является суммой двух наименьших положительных чисел.*/

package lab1.b3;

import lab1.CustomArr;

import java.io.IOException;

public class B3 {
    public static void main(String[] args) throws IOException {
        CustomArr arr = new CustomArr();
        arr.inputArray();
        if (arr.getLen() < 5) return;
        System.out.println(searchSumMin(arr.getArr()));
    }

    public static int searchSumMin(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (arr[i] < min1) {
                    min2 = min1;
                    min1 = arr[i];
                } else if (arr[i] < min2) {
                    min2 = arr[i];
                }
            }
        }
        if (min1 == Integer.MAX_VALUE || min2 == Integer.MAX_VALUE) return -1;
        return min1 + min2;
    }
}
