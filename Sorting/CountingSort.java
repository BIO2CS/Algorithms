package Sorting;

public class CountingSort {
   
    public static void countSort(int[] array, int k) {
        int n = array.length;
        int[] temp = new int[n];
        int[] counts = new int[k + 1];
        for (int i = 0; i < n; i++) {
            counts[array[i]]++;
        }
        for (int i = 1; i <= k; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            temp[counts[array[i]] - 1] = array[i];
            counts[array[i]]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = temp[i];
        }
    }
    
    public static void main(String[] args) {
        int[] numbers = {3, 6, 4, 5, 5, 9, 1};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        countSort(numbers, 9);
        System.out.println();
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}
