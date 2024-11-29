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


   private static void showArray(int[] array){
        for(int element:array){
            System.out.print(element + "\t");
        }
   }

    public static void main(String[] args) {

        int[] array = createVector(100000);
        int[] copy1 = copyArray(array);
        int[] copy2 = copyArray(array);
        int[] copy3 = copyArray(array);
        int[] copy4 = copyArray(array);

        double startTime = System.currentTimeMillis();
        int[] byShellSort = ShellSort.sort(copy1);
        double endTime = System.currentTimeMillis();
        double finalTime = endTime - startTime;

        double startTime2 = System.currentTimeMillis();
        int[] byHeapSort = HeapSort.heapSort(copy2);
        double endTime2 = System.currentTimeMillis();
        double finalTime2 = endTime2 - startTime2;

        double startTime3 = System.currentTimeMillis();
        int[] byMergeSort = MergeSort.sort(copy3, 0, copy3.length - 1);
        double endTime3 = System.currentTimeMillis();
        double finalTime3 = endTime3 - startTime3;

        double startTime4 = System.currentTimeMillis();
        int[] byQuickSort =  QuickSort.quickSort(copy4,0,copy4.length - 1);
        double endTime4 = System.currentTimeMillis();
        double finalTime4 = endTime4 - startTime4;

        System.out.println("ShellShort: " + finalTime + "ms");
        System.out.println("HeapSort: " + finalTime2 + "ms");
        System.out.println("MergeSort: " + finalTime3 + "ms");
        System.out.println("QuickSort: " + finalTime4 + "ms");

    }


}
