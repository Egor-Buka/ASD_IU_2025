package inversia;

public class Main {
    public static static void main(String[] args) {
        Inversia.FastScanner fs = new Inversia.FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int n = fs.nextInt();
        a = new Inversia.Item[n];
        temp = new Inversia.Item[n];

        for (int i = 0; i < n; i++) {
            long x = fs.nextLong();
            a[i] = new Inversia.Item(x, i + 1);
        }

        mergeSort(0, n);

        // Вывод количества инверсий
        out.append("Number of inversions: ").append(inversionCount).append('\n');

        // Вывод всех инверсий
        // Каждая пара — (i, j), где i < j и arr[i] > arr[j]
        for (int[] pair : inversions) {
            out.append(pair[0]).append(' ').append(pair[1]).append('\n');
        }

        System.out.print(out);
    }
}
