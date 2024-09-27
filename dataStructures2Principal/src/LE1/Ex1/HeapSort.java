package LE1.Ex1;

public class HeapSort {

    public static int[] heapSort(int[] heap){

        for(int walker = 0; walker < heap.length; walker++){
            reheapUp(heap,walker);
        }

        for(int i = heap.length - 1; i > 0; i--){
            int aux = heap[0];
            heap[0] = heap[i];
            heap[i] = aux;
            reheapDown(heap,0,i);
        }
        return heap;
    }

    private static void reheapUp(int[] heap, int index) {

        if (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index] > heap[parentIndex]) {
                int temp = heap[parentIndex];
                heap[parentIndex] = heap[index];
                heap[index] = temp;
                reheapUp(heap,parentIndex);
            }
        }
    }

    private static void reheapDown(int[] heap,int index, int size) {
        int leftSon = 2 * index + 1;
        int rightSon = 2 * index + 2;
        int largest = index;

        if (leftSon < size && heap[leftSon] > heap[largest]) {
            largest = leftSon;
        }

        if (rightSon < size && heap[rightSon] > heap[largest]) {
            largest = rightSon;
        }

        if (largest != index) {
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            reheapDown(heap,largest,size - 1);
        }
    }
}
