package LE1.Ex1;

//A ideia é dividir o vetor até que fiquem somente elementos unitários;
//Com isso, ele é novamente montado de forma recursiva e comparando os subvetores pelo caminho.
public class MergeSort {

    public static void merge(int[] v, int left, int middle, int right) {

        // transfere os elementos entre left e right para um array auxiliar.
        int[] helper = new int[v.length];
        for (int i = left; i <= right; i++) {
            helper[i] = v[i];
        }


        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {

            if (helper[i] <= helper[j]) {ls
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }
            k++;

        }

        // se a metade inicial não foi toda consumida, faz o append.
        while (i <= middle) {
            v[k] = helper[i];
            i++;
            k++;
        }

        // Não precisamos nos preocupar se a metade final foi
        // toda consumida, já que, se esse foi o caso, ela já está
        // no array final.

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
        MergeSort.sort(myArray, 0, myArray.length - 1);

        for (int i = 0; i < myArray.length - 1 ; i++) {
            System.out.println(myArray[i]);
        }

    }

}