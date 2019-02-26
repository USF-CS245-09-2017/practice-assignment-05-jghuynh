import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Numerically sorts an array using the Merge Sort technique
 * @author Justine Huynh
 * 02/25/2019
 */
public class MergeSort implements SortingAlgorithm {

    /**
     * Sorts the given integer array
     * @param myArray the given array
     */
    public void sort(int[] myArray)
    {
        mergeSort(myArray);
    }

    /**
     * Sorts the given integer array using the Merge Sort Technique
     * @param myArray the given array
     */
    private void mergeSort(int[] myArray)
    {
        if (myArray.length > 1)
        {
            int[] left = getLeft(myArray);
            int[] right = getRight(myArray);
            mergeSort(left);
            mergeSort(right);
            merge(myArray, left, right);
        }
    }

    /**
     * Gets the left half (including the middle) of a given integer array
     * @param myArray the given array
     * @return the left half of the array
     */
    private int[] getLeft(int[] myArray)
    {
        //int middleInd = myArray.length/2; // remember, gives me a whole number
        return Arrays.copyOfRange(myArray, 0, (myArray.length + 1)/2);
    }

    /**
     * Gets the right half (excluding the middle) of a given integer array
     * @param myArray the given array
     * @return the right half of the array
     */
    private int[] getRight(int[] myArray)
    {
        return Arrays.copyOfRange(myArray, (myArray.length + 1)/2, myArray.length);
    }

    /**
     * Merges an array
     * @param myArray the given original array
     * @param left the left half of an array to be merged to original array
     * @param right the right half of an array to be merged to original array
     */
    private void merge(int[] myArray, int[] left, int[] right){

        int ai = 0;
        int leftInd = 0;
        int rightInd = 0;

        while (leftInd < left.length && rightInd < right.length)
        {
            if (left[leftInd] <= right[rightInd])
            {
                myArray[ai] = left[leftInd];
                ai ++;
                leftInd ++;
            }
            else
            {
                myArray[ai] = right[rightInd];
                ai++;
                rightInd++;
            }
        }

        // copies all remaining extra elements from arrays left and right into myArray
        while (leftInd < left.length)
        {
            myArray[ai ++] = left[leftInd ++];
        }

        while (rightInd < right.length)
        {
            myArray[ai ++] = right[rightInd ++];
        }
    }

    public static void main(String[] args)
    {
        // Debugging
        int [] myArray = {0, 4, 5, 6, 3};
        int[] leftHalf = Arrays.copyOfRange(myArray, 0, (myArray.length)/2);
        int[] rightHalf = Arrays.copyOfRange(myArray, (myArray.length)/2, myArray.length);
        for (int i = 0; i < leftHalf.length; i ++)
        {
            System.out.print(leftHalf[i] + " ");
        }

        System.out.println();
        System.out.println("Left Half Of Array");
        for (int element: leftHalf)
        {
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println("Righ Half Of Array");
        for (int j = 0; j < rightHalf.length; j ++)
        {
            System.out.print(rightHalf[j] + " ");
        }
        // Andrew Nguyen's Debugging
        MergeSort sorter = new MergeSort();
        sorter.sort(myArray);
    }
}


