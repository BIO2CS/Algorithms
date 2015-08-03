package Sorting;

public class HeapSort {

    public static void heapSort(int[] A) {
        MaxHeap h = new MaxHeap(A);
        h.buildMaxHeap();
        for (int i = h.arraySize - 1; i > 0; i--) {
            swap(h.array, 0, i);
            h.heapSize--;
            h.maxHeapify(0);
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 9, -2, 5, 10, 2};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        heapSort(numbers);
        System.out.println();
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        
    //    System.out.println("\nMAX " + Integer.MAX_VALUE);
    }
}
