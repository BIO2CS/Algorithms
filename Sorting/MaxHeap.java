package Sorting;

public class MaxHeap {
    public int[] array;
    public int arraySize = 0;
    public int heapSize = 0;
    
    public MaxHeap(int[] A) {
        int n = A.length;
        array = A;
        arraySize = heapSize = n;
    }
    
    public void buildMaxHeap() {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }
    
    public int getParentIndex(int i) {
        return (i - 1) / 2;
    }
    
    public int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }
    
    public int getRightChildIndex(int i) {
        return 2 * i + 2;
    }
    
    public void maxHeapify(int i) {
        int left = getLeftChildIndex(i);
        int right = getRightChildIndex(i);
        int largest = i;
        if (left < heapSize && array[i] < array[left]) {
            largest = left;
        }
        if (right < heapSize && array[largest] < array[right]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;
            maxHeapify(largest);
        }
    }
}
