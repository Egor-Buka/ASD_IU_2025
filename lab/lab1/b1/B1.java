/* Дан целочисленный массив. Верните число, частота встречи которого в
массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
таких чисел несколько, вернуть наибольшее.*/

package lab1.b1;

import lab1.CustomArr;

import java.io.IOException;

public class B1 {
    public static void main() throws IOException {
        CustomArr arr = new CustomArr();
        arr.inputArray();
        int res = -1;
        for (int i = 0; i < arr.getArr().length; i++) {
            if (arr.getArr()[i] == find(arr.getArr(), arr.getArr()[i])) {
                res = max(res, arr.getArr()[i]);
            }
        }
        System.out.println(res);
    }

    public static int find(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static int max(int n1, int n2) {
        if (n1 > n2) return n1;
        else {
            return n2;
        }
    }
}
