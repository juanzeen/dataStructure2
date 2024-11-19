package LE1.Ex3;
import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    // Algoritmo de insertion sort para organizar cada bucket
    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    // Iniciando o bucketsort
    public static void sort(float[] arr) {
        int n = arr.length;

        // 1) criando um total de n buckets com base no tamanho do array
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2) colocando os elementos em diferentes buckets
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        // 3) organizando cada bucket individualmente com o insertionSort
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // 4) unindo todos os buckets em um array único
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    //main para executar o algoritmo de ordenação
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f, 0.100f, 0.101f, 0.324f, 0.542f, 0.867f, 0.975f};
        sort(arr);

        System.out.println("Sorted array is:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}

