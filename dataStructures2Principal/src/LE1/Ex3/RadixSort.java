package LE1.Ex3;
import java.io.*;
import java.util.*;

class RadixSort {

    private static int[] createVector(int size){

        int[] vector = new int[size];
        for(int index = 0; index < vector.length;index++){
            vector[index] = (int) (Math.random() * 101);
        }
        return vector;
    }

   //funcao para encontrar o maior valor dentro do vetor
    static int getMax(int[] array)
    {
        int m = 0;

        //loop para achar o maior valor do array
        for (int x : array) {
            m = Math.max(m, x);
        }

        return m;
    }

    // counting sort com base no tamanho do array
    static void countSort(int[] arr, int n, int exp)
    {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // armazena a contagem em um vetor
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        //Altera a contagem para que tenha o índice do vetor de saída
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Cria o vetor de saída
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        //Copia o vetor saída no vetor original para que ele fique organizado
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Função principal do radixSort
    static void radixsort(int[] arr, int n)
    {
        // Achando valor máximo
        int m = getMax(arr);

        //Faz countingSort com base em cada dígito, ao invés de passar o dígito passamos exp,
        //onde exp é 10^i, que é o digito atual do número
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void print(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args)
    {
        int[] arr = createVector(1000000);


        radixsort(arr, arr.length);
        print(arr, arr.length);
    }
}
