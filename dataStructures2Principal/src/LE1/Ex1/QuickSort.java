package LE1.Ex1;

public class QuickSort {

    public static int[] quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end);
            quickSort(array, begin, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
        return array;
    }

    private static int partition(int[] array, int begin, int end) {

        int mid = begin + (end - begin) / 2;
        int pivot = medianOfThree(array, begin, mid, end);

        if (pivot != array[end]) {
            int temp = array[pivot];
            array[pivot] = array[end];
            array[end] = temp;
        }

        pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i + 1;
    }

    private static int medianOfThree(int[] array, int begin, int mid, int end) {
        if (array[begin] > array[mid]) {
            int temp = array[begin];
            array[begin] = array[mid];
            array[mid] = temp;
        }
        if (array[begin] > array[end]) {
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
        }
        if (array[mid] > array[end]) {
            int temp = array[mid];
            array[mid] = array[end];
            array[end] = temp;
        }
        return mid;
    }
}
