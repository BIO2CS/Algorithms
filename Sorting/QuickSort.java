
package Sorting;

public class QuickSort {

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }
    
    private static void sort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }
   
    private static int partition(int[] array, int p, int r) {
        int randomIndex = p + (int) (Math.random() * (r - p + 1));
        swap(array, randomIndex, r);
        int i = p - 1, j = p;
        while (j < r) {
            if (array[j] < array[r]) {
                swap(array, ++i, j);
            }
            j++;
        }
        swap(array, ++i, r);
        return i;
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 2, -2, 5, 10, 1};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        quickSort(numbers);
        System.out.println();
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}
