package LE1.Ex1;

//A ideia é dividir o vetor até que fiquem somente elementos unitários;
//Com isso, ele é novamente montado de forma recursiva e comparando os subvetores pelo caminho.
public class MergeSort {

    public static int[] merge(int[] array, int base, int mid, int top){
        int length1 = mid - base + 1, length2 = top - mid;
        int[] left = new int[length1-1], right = new int[length2-1];
        for(int i = 0; i < length1 - 1; i++){
            left[i] = array[base + i];
        }
        for(int j = 0; j < length2 - 1; j++){
            right[j] = array[mid + j + 1];
        }
        left[length1] = (int) Double.POSITIVE_INFINITY;
        right[length2] = (int) Double.POSITIVE_INFINITY;

        int i = 0, j = 0;
        for(int k = base; k < top; k++){
            if(left[i] <= right[j]){
                array[k] = left[i];
                i++;
            }else{
                array[k] = right[j];
                j++;
            }
        }
        return array;
    }


    public static int[] sort(int[] array, int base, int top){
        if(base < top){
            int mid = (base + top)/2;
            MergeSort.sort(array, base, mid);
            MergeSort.sort(array, mid+1, top);
            MergeSort.merge(array, base, mid, top);
        }
        return array;

    }

    public static void main(String[] args) {
        int[] myArray = {1, 5, 32, 21, 54, 654, 4321, 3421, 7, 8, 86, 89, 65, 99, 90643, 543};
        int[] sorted = MergeSort.sort(myArray, 0, myArray.length);

        for (int i = 0; i < myArray.length ; i++) {
            System.out.println(sorted);
        }

    }

}
