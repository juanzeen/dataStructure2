package LE1.Ex3;


import java.util.Arrays;

public class CountingSort {
    private static int[] createArray(int size){

        int[] array = new int[size];
        for(int index = 0; index < array.length;index++){
            array[index] = (int) (Math.random() * 1000001);
        }
        return array;
    }

    public static int[] sort(int[] inputArray) {
        int max = 0;

        //loop para achar o maior valor do array
        for (int i = 0; i < inputArray.length; i++) max = Math.max(max, inputArray[i]);


        //cria o vetor de contagem pegando o maior valor + 1
        //dessa forma garantimos que o vetor tenha  tamanho correto
        int[] countArray = new int[max + 1];
        Arrays.fill(countArray, 0);

        for (int i = 0; i < inputArray.length; i++) countArray[inputArray[i]]++;

        //faz o vetor de contagem acumulada
        for (int i = 1; i < countArray.length; i++) countArray[i] += countArray[i - 1];

        //inicializa o vetor de saída
        int[] outputArray = new int[inputArray.length];

        //organiza o vetor saída a partir do último elemento do vetor entrada
        for (int i = inputArray.length - 1; i >= 0; i--) {
            //pega o ultimo elemento do vetor entrada
            //usa ele como índice para acessar o vetor de contagem acumulada
            //tendo a contagem acumulada desse elemento subtraímos 1, nessa posição inserimos o elemento
            // inicial[1,0,2] -> acc[1, 2, 3] -> quero inserir 2, coloco esse índice no acc e acho que o acumulado é 3
            //com base no acumulado, subtraio um e encontro que a posição onde o 2 será inserido é a posição 2 do vetor saída [_, _, 2]
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = createArray(100000);
        int[] outputArray = sort(inputArray);

        for (int x : outputArray) System.out.print(x + " ");

    }
}