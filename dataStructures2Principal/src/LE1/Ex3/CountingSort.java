package LE1.Ex3;

import java.util.Arrays;

public class CountingSort {
    public static int[] sort(int[] inputArray) {
        int max = 0;

        //loop para achar o maior valor do array
        for (int i = 0; i < inputArray.length; i++) {
            max = Math.max(max, inputArray[i]);
        }

        //cria o vetor de contagem pegando o maior valor + 1
        int[] countArray = new int[max + 1];

        for (int i = 0; i < inputArray.length; i++) {
            countArray[inputArray[i]]++;
        }
        //faz o vetor de contagem acumulada
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }
        //inicializa o vetor de saída
        int[] outputArray = new int[inputArray.length];

        //organiza o vetor saída a partir do último elemento do vetor entrada
        for (int i = inputArray.length - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9, 6, 4, 7, 8, 9, 14, 16, 11, 23};
        int[] outputArray = sort(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(outputArray[i] + " ");
        }
    }
}