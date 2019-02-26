/**
 * Numerically sorts a given integer array using the Quick Sort technique
 * @author Justine Huynh
 * 02/25/2019
 */
public class QuickSort implements SortingAlgorithm {

    /**
     * Numerically sorts a given integer array using the Quick Sort technique
     * @param myArray the array to be sorted
     */
    public void sort(int [] myArray)
    {
        // quicksort already sorted the array..
        // left = leftmost index
        // right = rightmost index
        int left = 0;
        int right = myArray.length - 1;
        quicksort(myArray, left, right);
    }

    /**
     * Sorts a given integer array using Quick Sort technique
     * @param arr the given integer array
     * @param left the leftmost index
     * @param right the rightmost index
     */
    private void quicksort(int[] arr, int left, int right) {

        if (left < right) {
            int p = partition(arr, left, right);
            quicksort(arr, left, p - 1);
            quicksort(arr, p + 1, right);
        }
    }

    /**
     * Partitions, or splits, a given array
     * @param arr the given array
     * @param left the left index
     * @param right the right index
     * @return the new pivot
     */
    private int partition(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = left;
            int i = left + 1; // Avoids re-sorting the pivot
            int j = right;
            while (i < j) {
                while (i <= right && arr[i] <= arr[pivot]) {
                    ++i;
                }
                while (j >= i && arr[j] > arr[pivot]) {
                    --j;
                }
                if (i <= right && i < j) {
                    swap(arr, i, j);
                }
            }
            swap(arr, pivot, j);  // pivot to the middle
            return j;
        }
        return left;
    }

    /**
     * Swaps 2 elements in an array
     * @param myArray the integer array
     * @param i the previous, first index
     * @param j the subsequent, second index
     */
    private void swap(int[] myArray, int i, int j)
    {
        int temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;

    }
}
