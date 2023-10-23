
public class quickSortV2{
    public static void main(String[] args){
        //int array[] = new int[]{10,15,8};
        int array[] = new int[]{10,5,8,12,7,6,15,9,16};
        //partition(array, 0, array.length - 1);
        quickSort(array, 0, array.length - 1); 
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
     *  6. once i reaches the end of the array, we will increment last_small by 1 and swap (pivot location (first index) and last_small index)
     *  7. ending the partiton algo
     */
    public static int partition(int array[], int low, int high){

        int midPoint = (high + low)/2;
        int pivot = array[midPoint]; //store the pivot value as "pivot"
        int last_small = low; //marks the final location for pivot
        //swap the positions of pivot/midpoint and 1st element in the array
        swap(array, low, midPoint);
        printArray(array);
        //traverse the array and perform key comparisons (starting from index = 1 since index  = 0 is our pivot)
        for(int i = low + 1; i <= high; i++){
            //compare the current element with pivot
            if(array[i] < pivot){ //if current element is smaller than pivot-> we increment last_small first then swap position of array[i] and last_small
                ++last_small;
                swap(array, last_small, i);
            }
            //else if current element is greater than pivot -> we only increment i(continue traversing down)'
        }
        //once we complete the partition, we then swap the positions of last_small and pivot(array[0])
        swap(array, low, last_small);
        //now we should have a partition-ed array where everything on the left of pivot is smaller than itself and everything on the right
        //is larger or equal than itself
        System.out.println(last_small);
        return last_small;
    }


    public static void quickSort(int array[], int low, int high){
        if(low < high){
            int pivot = partition(array, low, high);
            quickSort(array, low , pivot - 1);
            quickSort(array, pivot + 1, high);
        }
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
