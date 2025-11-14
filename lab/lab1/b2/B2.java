/*Пусть любое число – это массив его цифр слева направо. Пример, число
1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом. */

package lab1.b2;

import lab1.CustomArr;

import java.io.IOException;
import java.math.BigInteger;

public class B2 {
    public static void main(String[] args) throws IOException {
        CustomArr arr1 = new CustomArr();
        CustomArr arr2 = new CustomArr();
        arr1.inputArray();
        arr2.inputArray();
        BigInteger n1 = converterArrToBigInteger(arr1.getArr());
        BigInteger n2 = converterArrToBigInteger(arr2.getArr());
        BigInteger n = n1.multiply(n2);
        int[] resultArr = converterBigIntegerToArr(n);
        CustomArr result = new CustomArr();
        result.setArray(resultArr);
        result.printArray();
    }

    public static BigInteger converterArrToBigInteger(int[] arr) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        return new BigInteger(s.toString());
    }

    public static int[] converterBigIntegerToArr(BigInteger n) {
        String s = n.toString();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        return arr;
    }
}
