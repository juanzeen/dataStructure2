package LE1.Ex1;

public class Exercise1 {

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

    public static void main(String[] args) {

        int[] array = createVector(10);
        int[] copy1 = copyArray(array);
        int[] copy2 = copyArray(array);
        int[] copy3 = copyArray(array);
        int[] copy4 = copyArray(array);

        long startTime = System.currentTimeMillis();
        int[] byShellSort = ShellSort.sort(copy1);
        long endTime = System.currentTimeMillis();
        long finalTime = endTime - startTime;

        long startTime2 = System.currentTimeMillis();
        ////
        long endTime2 = System.currentTimeMillis();
        long finalTime2 = endTime2 - startTime2;

        long startTime3 = System.currentTimeMillis();
        ///
        long endTime3 = System.currentTimeMillis();
        long finalTime3 = endTime3 - startTime3;

        long startTime4 = System.currentTimeMillis();

        long endTime4 = System.currentTimeMillis();
        long finalTime4 = endTime4 - startTime4;

        System.out.println("ShellShort: " + finalTime);
        System.out.println("HeapSort" + finalTime2);
        System.out.println("MergeSort: " + finalTime3);
        System.out.println("QuickSort: " + finalTime4);

    }


}
