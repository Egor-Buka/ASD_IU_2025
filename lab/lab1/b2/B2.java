/*Пусть любое число – это массив его цифр слева направо. Пример, число
1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом. */

package lab1.b2;

import lab1.CustomArr;

import java.io.IOException;

public class B2 {
    public static void main(String[] args) throws IOException {
        CustomArr arr1 = new CustomArr();
        CustomArr arr2 = new CustomArr();
        arr1.inputArray();
        arr2.inputArray();
        int n1 = converterArrToInt(arr1.getArr());
        int n2 = converterArrToInt(arr2.getArr());
        long n = n1 * n2;
        int[] resultArr = converterLongToArr(n);
        CustomArr result = new CustomArr();
        result.setArray(resultArr);
        result.printArray();
    }

    public static int converterArrToInt(int[] arr) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        return Integer.parseInt(s.toString());
    }

    public static int[] converterLongToArr(long n) {
        String s = Long.toString(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        return arr;
    }
}
