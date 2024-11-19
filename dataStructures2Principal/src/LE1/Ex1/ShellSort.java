package LE1.Ex1;

public class ShellSort {

    public static int[] sort(int[] array) {
        // Calcular o maior gap inicial usando a fórmula de Knuth
        int gap = 1;
        while (gap < array.length) {
            gap = gap * 3 + 1; // 3^k - 1
        }
        gap = (gap - 1) / 3; // Ajusta para o maior gap válido

        // Realiza o Shell Sort com o gap calculado
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i;

                // Ordenação por inserção modificada
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }

            // Atualiza o gap para o próximo menor valor da sequência de Knuth
            gap = (gap - 1) / 3;
        }

        return array;
    }
}
