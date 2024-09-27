package LE1.Ex1;

public class ShellSort {
    public static int[] sort(int[] array){
        //intervalo que será usado no começo das iterações
        int gap =  array.length % 2 == 0? array.length/2 : (int) Math.floor( (double) array.length/2);

        for(int i = 0; gap>= 1 ; i++){

            if( i + gap > array.length - 1){
                gap -= 1;
                i = 0;
            }

            if (array[i] > array[i + gap]){
                int aux = array[i];
                array[i] = array[i + gap];
                array[i + gap] = aux;
            }
        }

        return array;
    }
}
