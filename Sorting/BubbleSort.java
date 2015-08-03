package Sorting;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap (array, j, j + 1);
                }
            }
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 9, -2, 5};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        bubbleSort(numbers);
        System.out.println();
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}
