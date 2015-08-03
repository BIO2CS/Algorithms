package Sorting;

public class MergeSort {

    //this is to address the question on Page 39 in CLRS 2nd edition
    private static int inversionCounts = 0;
    public static void mergeSort(int[] array) {
        int length = array.length;
        int[] temp = new int[length];
        sort(array, 0, length - 1, temp);
    }
    
    private static void sort(int[] array, int i, int j, int[] temp) {
        if (i >= j) return;
        int mid = (i + j) / 2;
        sort(array, i, mid, temp);
        sort(array, mid + 1, j, temp);
        merge(array, i, mid, j, temp);
    }
    
    private static void merge(int[] array, int i, int k, int j, int[] temp) {
        int left = i, right = k + 1, index = i;
        while(left <= k && right <= j) {
            if (array[left] < array[right]) {
                temp[index++] = array[left++];
            }
            else {
                temp[index++] = array[right++];
                inversionCounts += (k - left + 1);
            }
        }
        while(left <= k) {
            temp[index++] = array[left++];
        }
        while(right <= j) {
            temp[index++] = array[right++];
        }
        for (index = i; index <= j; index++) {
            array[index] = temp[index];
        }
    }
    
    public static void main(String[] args) {
        int[] numbers = {8, 6, 3, 2, 1};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        mergeSort(numbers);
        System.out.println();
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println(inversionCounts);
    }
}
