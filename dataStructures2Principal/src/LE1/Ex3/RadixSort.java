package LE1.Ex3;

import java.io.*;
import java.util.*;

class RadixSort {

   //funcao para encontrar o maior valor dentro do vetor
    static int getMax(int array[], int n)
    {
        int m = 0;

        //loop para achar o maior valor do array
        for (int i = 0; i < array.length; i++) {
            m = Math.max(m, array[i]);
        }

        return m;
    }

    // counting sort com base no tamanho do array
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
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
    static void radixsort(int arr[], int n)
    {
        // Achando valor máximo
        int m = getMax(arr, n);

        //Faz countingSort com base em cada dígito, ao invés de passar o dígito passamos exp,
        //onde exp é 10^i, que é o digito atual do número
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args)
    {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66, 200, 321, 43, 54, 65, 312, 532, 123, 312,3, 54, 5, 6,56,5, 432, 90321, 3212, 4321, 98, 31, 27, 95 };

        radixsort(arr, arr.length);
        print(arr, arr.length);
    }
}