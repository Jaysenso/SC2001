
public class quickSortV2{
    static int SIZE = 20;
    public static void main(String[] args){

        int array[] = new int[]{10,5,8,12,7,6,15,9,16}; 
        quickSort(array, 0, array.length -1);
        printArray(array);

    }
    /*
     * Algorithm:
     *  1. we select midpoint as our pivot (1st index + last index)/2
     *  2. swap(pivot，array[0]) <- we move our pivot to the 1st element of array
     *  3. we have indices "last_small" and "i" tracking the location of my border
     *     between the elements < pivot & elements >= pivot and i" will be traversing
     *     down the array for key comparisons respectively
     *  4. if array[i] is less than pivot, we will swap(++last_small, i)
     *  5. if array[i] is greater than pivot, we will do nothing and just increment i (for loop)
     *  6. once i reaches the end of the array, we will swap pivot back to the mid point 
     *  7. ending the partiton algo
     */
    public static int partition(int array[], int low, int high){
        //we will store this seperately since we need to swap back after the partition\
        System.out.printf("%d %d\n",high, low);
        printArray(array);
        int midPoint = (high + low)/2;
        int last_small = low;
        int pivot = array[midPoint];
        //bring pivot to index 0
        swap(array,0, midPoint);
        //we starting from array[0 + 1] where array[0] is our pivot
        for(int i = 1; i < array.length - 2 ; i++){
            if(array[i] < pivot)
                swap(array, ++last_small, i);
        }
        swap(array, 0, last_small);
        return last_small;
    }


    public static void quickSort(int array[], int low, int high){
        if(low >= high)
            return;

        int pivot = partition(array, low, high);
        quickSort(array, low , pivot - 1);
        quickSort(array, pivot + 1, high);
    }


    public static void swap(int array[], int firstIndex, int secondIndex){

        int temp = array[secondIndex];
        array[secondIndex] = array[firstIndex];
        array[firstIndex] = temp;
    }

    public static void printArray(int array[]){
        System.out.printf("[");
        for(int i = 0; i < array.length; i++){
            System.out.printf("%d", array[i]);
            if(i < array.length - 1)
                System.out.printf(",");
        }       
        System.out.println("]");
    }
}
