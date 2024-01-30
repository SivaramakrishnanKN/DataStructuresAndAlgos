package DivideAndConquer;

import java.util.Arrays;

/**
 *
 *  In the first step, we divide the list into two sublists.  (Divide)
 *  Then in the next step, we recursively sort the sublists in the previous step.  (Conquer)
 * Finally we merge the sorted sublists in the above step repeatedly to obtain the final list of sorted elements.  (Combine)
 */
public class MergeSort {
    private static int[] mergeSort(int[] arr) {
        
        if(arr.length<=1) {
            return arr;
        }
        int n = arr.length;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, n/2));
        int[] right = mergeSort(Arrays.copyOfRange(arr, n/2, n));
        
        int[] merged = new int[n];
        int l=0, r=0, i=0;
        while(l<left.length && r<right.length) {
            if(left[l]<right[r]) {
                merged[i++] = left[l++];
            } else {
                merged[i++] = right[r++];
            }
        }
        while(l<left.length) {
            merged[i++] = left[l++];
        }
        while(r<right.length) {
            merged[i++] = right[r++];
        }
        return merged;
    }
    public static void main(String[] args) {
        int[] array = {9,1,2,5,3,4,10};
        
        int[] sorted = mergeSort(array);
        System.out.print("\n");
        for(int x:sorted){
            System.out.print(x+", ");
        }
        System.out.print("\n");
    }
}
