package LE1.Ex1;

//A ideia é dividir o vetor até que fiquem somente elementos unitários;
//Com isso, ele é novamente montado de forma recursiva e comparando os subvetores pelo caminho.
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

        int x = 0, y = 0;

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
