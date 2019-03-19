/**
 * Numerically sorts the array by the Insertion method
 * @author  Justine Huynh
 * 02/15/2019
 */
public class InsertionSort implements SortingAlgorithm {

    /**
     * Numerically sorts the array by the Insertion method
     * @param myArray the array to be sorted
     */
    public void sort(int[] myArray)
    {
        for (int index = 1; index < myArray.length; index ++)
        {
            int minValue = myArray[index]; // create the temp variable for current value
            int prevIndex = index - 1;
            // Checks to see if any elements in myArray[0, ... index - 1]
            // if greater than the temp/minValue.
            while (prevIndex >= 0 && myArray[prevIndex] > minValue)
            {
                // if the previous value is greater than the temp/current value, switch
                myArray[index] = myArray[index - 1];
                prevIndex --; // keep going back
                index --;
            }
            myArray[prevIndex + 1] = minValue; // update where the temp/minValue is
        }
    }
}
