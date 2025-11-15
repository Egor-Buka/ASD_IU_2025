package lab1.binarysearch;

import lab1.CustomArr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
    public static int getTarget() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите элемент для поиска: ");
        return Integer.parseInt(br.readLine());
    }

    public static void outputResult(int result, CustomArr arr) {
        System.out.println("Отсортированный массив: \n");
        arr.printArray();
        if (result != -1) {
            System.out.println("Элемент найден на позиции: " + result);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
