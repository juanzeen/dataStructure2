package LE1.Ex3;
import java.util.*;

class RadixSort {

    private static int[] createArray(int size){

        int[] array = new int[size];
        for(int index = 0; index < array.length;index++){
            array[index] = (int) (Math.random() * 1000000001);
        }
        return array;
    }

   //funcao para encontrar o maior valor dentro do vetor
    static int getMax(int[] array)
    {
        int max = 0;

        //loop para achar o maior valor do array
        for (int x : array) {
            max = Math.max(max, x);
        }

        return max;
    }

    static void countingSort(int[] array, int n, int exp)
    {
        int[] outputArray = new int[n]; // output array
        int i;
        int[] countArray = new int[10];
        Arrays.fill(countArray, 0);

        //a única mudança é a forma de acessar o elemento no array original
        for (i = 0; i < n; i++)
            countArray[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            countArray[i] += countArray[i - 1];

        for (i = n - 1; i >= 0; i--) {
            outputArray[countArray[(array[i] / exp) % 10] - 1] = array[i];
            countArray[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            array[i] = outputArray[i];
    }

    // Função principal do radixSort
    static void radixsort(int[] array, int n)
    {
        // Achando valor máximo
        int bigger = getMax(array);

        //Faz countingSort com base em cada dígito, ao invés de passar o dígito passamos exp,
        //onde exp é 10^i, que é usado para encontrar o dígito atual do número
        for (int exp = 1; bigger / exp > 0; exp *= 10)
            countingSort(array, n, exp);
    }

    static void print(int[] array, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
    }

    public static void main(String[] args)
    {
        int[] arr = createArray(1000);


        radixsort(arr, arr.length);
        print(arr, arr.length);
    }
}
