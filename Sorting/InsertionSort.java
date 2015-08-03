
package Sorting;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr; 
        }
    }
    
    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 9, -2, 5};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        insertionSort(numbers);
        System.out.println();
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}
