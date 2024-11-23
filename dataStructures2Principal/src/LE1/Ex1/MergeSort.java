package LE1.Ex1;

public class MergeSort {

    public static void merge(int[] array, int floor, int mid, int top){
        //declaração dos tamanhos e dos arrays
        int lengthL = mid - floor + 1;
        int lengthR = top - mid;
        int[] leftArray = new int[lengthL];
        int[] rightArray = new int[lengthR];

        //preenchimento dos arrays esquerdo e direito
        for(int i = 0; i < lengthL - 1; i++){
            leftArray[i] = array[floor + i];
        }

        for(int j = 0; j < lengthR - 1; j++){
            rightArray[j] = array[mid + j + 1];
        }

        //preenchendo o último elemento com um valor "infinito"
        leftArray[lengthL -1] = Integer.MAX_VALUE;
        rightArray[lengthR - 1] = Integer.MAX_VALUE;

        //declarando iteradores para montar vetor final
        int x = 0, y = 0;

        //monta vetor final comparando elementos esquerdos e direitos
        for(int k = floor; k < top - 1; k++){
            if(leftArray[x] <= rightArray[y]){
                array[k] = leftArray[x];
                x++;
            }else{
                array[k] = rightArray[y];
                y++;
            }
        }
    }

    //chamada recursiva que tem como parada o valor inicial >= ao final
    public static int[] sort(int[] array, int floor, int top){
        if(floor < top){
            int mid = floor + (top - floor) /2;
            sort(array, floor, mid);
            sort(array, mid + 1, top);
            merge(array, floor, mid, top);
        }
        return array;
    }
}
