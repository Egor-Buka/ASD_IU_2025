package inversia;

import java.io.*;
import java.util.*;

/* Дан массив arr из N элементов. Назовем инверсией пару индексов (i, j),
таких что i < j и arr[i] > arr[j]. Требуется определить количество инверсий в
данном массиве и вывести их. Дать комментарии. Вычислить сложность. Используем декомпозицию*/
public class Inversia {
    private static class Item {
        long value;
        int index; // индекс в исходном массиве (1..N)

        Item(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private static Item[] a;
    private static Item[] temp;
    private static long inversionCount = 0;
    private static List<int[]> inversions = new ArrayList<>();

    public static void main(String[] args) throws Exception {

    }


    private static void mergeSort(int left, int right) {
        // Отрезок длины 0 или 1 уже отсортирован
        if (right - left <= 1) {
            return;
        }

        int mid = (left + right) / 2;

        // Сортируем левую и правую половины
        mergeSort(left, mid);
        mergeSort(mid, right);

        // Сливаем две отсортированные половины и считаем инверсии между ними
        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int i = left;  // указатель по левому отрезку
        int j = mid;   // указатель по правому отрезку
        int k = left;  // указатель в temp

        while (i < mid && j < right) {
            if (a[i].value <= a[j].value) {
                // Инверсий нет: левый элемент меньше или равен правому
                temp[k++] = a[i++];
            } else {
                // a[i].value > a[j].value -> инверсии
                // Все элементы a[i..mid-1] образуют инверсию с a[j]
                inversionCount += (mid - i);

                // Сохраняем сами пары (индексы)
                for (int p = i; p < mid; p++) {
                    inversions.add(new int[]{a[p].index, a[j].index});
                }

                // В слияние идёт элемент из правого подмассива
                temp[k++] = a[j++];
            }
        }

        // Копируем остаток левой части, если что-то осталось
        while (i < mid) {
            temp[k++] = a[i++];
        }

        // Копируем остаток правой части, если что-то осталось
        while (j < right) {
            temp[k++] = a[j++];
        }

        // Переписываем отсортированный участок обратно в a
        for (int t = left; t < right; t++) {
            a[t] = temp[t];
        }
    }

    private static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
