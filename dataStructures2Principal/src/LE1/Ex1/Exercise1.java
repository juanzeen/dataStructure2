package LE1.Ex1;

public class Exercise1 {

    public static void main(String[] args) {

        int[] array = createVector(100000);
        int[] copy1 = copyArray(array);
        int[] copy2 = copyArray(copy1);
        int[] copy3 = copyArray(copy1);

        long startTime = System.currentTimeMillis();
        int[] testHeap = HeapSort.heapSort(copy1);
        long endTime = System.currentTimeMillis();
        long finalTime = endTime - startTime;
        System.out.println("heap: " + finalTime);

        long startTime2 = System.currentTimeMillis();
        int[] testQuick =  QuickSort.quickSort(copy2,0,copy2.length - 1);
        long endTime2 = System.currentTimeMillis();
        long finalTime2 = endTime2 - startTime2;
        System.out.println("quick: " + finalTime);

        long startTime3 = System.currentTimeMillis();
        ///
        long endTime3 = System.currentTimeMillis();
        long finalTime3 = endTime3 - startTime3;

        long startTime4 = System.currentTimeMillis();
        ///
        long endTime4 = System.currentTimeMillis();
        long finalTime4 = endTime4 - startTime4;

    }


    private static int[] createVector(int size){

        int[] vector = new int[size];
        for(int index = 0; index < vector.length;index++){
            vector[index] = (int) (Math.random() * 101);
        }
        return vector;
    }

   private static int[] copyArray(int[] array){
        int[] copy = new int[array.length];
        for(int index = 0; index < array.length; index++){
            copy[index] = array[index];
        }
        return copy;
    }

   private static void showArray(int[] array){
        for(int element:array){
            System.out.print(element + "\t");
        }
   }


}
