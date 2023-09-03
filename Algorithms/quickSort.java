public class quickSort{
    public static void main(String[] args){

        //declare array & allocate memory
        int array[] = new int[]{10,5,8,12,15,6,3,9,16};
        int tempArray[] = new int[array.length];
        for(int i = 0; i < array.length;i++){
            tempArray[i] = array[i];
        }
        //populate array size 10 with random int between 1 - 100
        /*for(int i = 0; i < 10; i++){
            array[i] = (int)(Math.random() * 100 + 1);
            System.out.println(array[i]);
        }*/
        quickSortMethod(array, 0, array.length - 1);


        System.out.println();
        System.out.println("Before partition:");
        printArray(tempArray);
        System.out.println("After partition:");
        printArray(array);

    }
/*  
    
    * partition algorithm: (we picking pivot as the 1st element) <- might not be the most optimal (worst case O(n^2))
    * 1. have 2 indices (i and j) pointing at the first and last elements respectively
    * 2. mark the 1st element (pivot) as our pivot
    * 3. increment i until we find an element greater than our pivot
    * 4. decrement j until we find an elment smaller than our pivot
    * 5. when both indices found their elements -> we swap the elements in array[i] and array[j]
    * 6. repeat 3,4,5
    * 7. when i crossed j -> wherever j is pointing is where i want to place my pivot 
    *   (everything on the left is smaller and everything on right is bigger)
    * 8. swap pivot and array[j]
    */
    public static int partition(int array[], int low, int high){
        //mark the 1st element as our pivot
        int pivot = array[low];
        int i = low; //i will start from the first element
        int j = high; //j will start from the last element
        int temp;

        //we will keep swapping till j crosses i
        while(i < j){
            do{ //increment i until we find an element greater than our pivot
                i++;
            }while(array[i] <= pivot);
            do{ //decrement j until we find an elment smaller than our pivot
                j--;
            }
            while(array[j] > pivot);
            // swap i and j elements
            if(i < j){
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        //swap array[0] and array[j]
        array[low] = array[j];
        array[j] = pivot;
        //returns the pivot location
        return j;
    }


    public static void quickSortMethod(int array[], int low, int high){
        if(low < high){
            int j = partition(array, low, high);
            quickSortMethod(array, low, j);
            quickSortMethod(array, j + 1, high);
        }
    }


    public static void printArray(int[] array){
        System.out.printf("[");
        for(int i = 0; i < array.length; i++){

            System.out.printf("%d",array[i]);
            if(i < array.length - 1)
                System.out.printf(",");
        }
        System.out.println("]");
    }



}