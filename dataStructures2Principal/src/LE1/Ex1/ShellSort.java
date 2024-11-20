package LE1.Ex1;

public class ShellSort {

    public static int[] sort(int[] array) {
        // calcular o maior gap inicial usando a fórmula de Knuth
        int gap = 1;
        while (gap < array.length) {
            gap = gap * 3 + 1; // 3^k - 1
        }
        gap = (gap - 1) / 3; // ajusta para o maior gap válido usando a formula inversa

        // execucao do shellsort
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                //determina um valor de comparacao e dá um indice a j
                //esse indice comeca no gap e cresce de 1 em 1 até igualar o tamanho do vetor
                //quando iguala, um novo gap é calculado
                int temp = array[i];
                int j = i;

                //loop onde ocorre a ordenação
                //na primeira iteração j é igual ao gap, entao vai ser feito só uma vez
                //contudo, j cresce conforme i cresce, o que garante a validade da primeira condição
                //a segunda condicao é o indice atual ser um valor menor do que o que ficou para trás
                //no caso, o valor temporario que seria o indice i
                //caso ambas sejam satisfeitas, trocamos os valores e decrementamos o j em um gap
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }

            // atualiza o gap quando o vetor todo é percorrido
            gap = (gap - 1) / 3;
        }

        return array;
    }
}
