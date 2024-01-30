package DivideAndConquer;

public class QuickSort {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int pivotLoc = l;
        for(int i=l; i<r; i++) {
            if(arr[i] < pivot) {
                swap(arr, i, pivotLoc++);
            }
        }
        swap(arr, r, pivotLoc);
        return pivotLoc;
    }
    void quickSort(int[] arr, int l, int r) {
        if(l<r) {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, r);    
        }
    }

    // Select kth element sorted from the end.
    void quickSelect(int[] arr, int l, int r, int k) {
        System.out.println("c");
        int pivot = partition(arr, l, r);
        if(pivot == k) {
            return;
        }
        if(pivot < k) {
            quickSelect(arr, pivot+1, r, k);
        }
        if(pivot > k) {
            quickSelect(arr, l, pivot-1, k);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[] {9,8,7,6,5,4,3,2,1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length-1);
        for(int x:arr) {
            System.out.print(x+ " ");
        }
        System.out.println("\nQuick Select");
        int[] arr1 = new int[] {9,8,7,6,5,4,3,2,1};
        quickSort.quickSelect(arr1, 0, arr1.length-1, 2);
        for(int x:arr1) {
            System.out.print(x+ " ");
        }
    }
}
