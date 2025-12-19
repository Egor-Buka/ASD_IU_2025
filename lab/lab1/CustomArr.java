package lab1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CustomArr {
    private int len;
    private int[] array;

    public void inputArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество элементов: ");
        len = Integer.parseInt(br.readLine());
        array = new int[len];
        System.out.println("Введите сами элементы: ");
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < len; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void printArray() {
        System.out.println("Массив: ");
        for (int i = 0; i < len; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    public int[] getArr() {
        return array;
    }

    public int getLen() {
        return array.length;
    }

    public void setArray(int[] array) {
        this.array = array;
        this.len = array.length;
    }
}

