public class iterativeHeapSort {
    public static void main(String[] args){


        int[] array = new int[]{17,12,8,7,6,30,4};
        printArray(array);
        heapSortAlgo(array, array.length);
        printArray(array);

    }
    //for this iterative HeapSort (heapify & commonly known fixHeap works the same way) 
    public static void heapSortAlgo(int array[], int arraySize){
        //this loop will help to construct the maxHeap tree starting from the last non-leaf nodes
        for(int i = arraySize/2 - 1; i >= 0; i--){
            heapify(array, arraySize, i);
        }
        //At this stage, we would have a MaxHeap tree, then we will partition the array/tree into unsorted and sorted
            //In maxHeap tree,the largest element == rootNode element, hence we need to shift it to the back of the array (for ascending sort)
            //We can achieve this by swapping the last node and our root node(basically first element and last element in the array)
            //However, after swapping, we cannot guarantee that we did not violate the MaxHeap tree properties(parentNode >= both childNodes) 
            //Therefore we call Heapify again to fix the tree (similar to the for loop above) <-- commonly known as FixHeap
            //to ensure that our tree abides the Maxheap properties
            //We will reduce the arraySize by 1 after every iteration to prevent heapify from fixing our sorted elements
            //repeat this process till we have a sorted array
        for(int i = arraySize - 1; i > 1; i--){
            swap(array, 0, i);
            heapify(array, i, 0); //fixheap starting from rootNode with arraySize decreasing by 1 after every iteration
        }

    }
    public static void heapify(int array[], int arraySize, int parentIndex){
        //initialize largest pointer to point at parentIndex, we will update it when we find a larger chilNode >= parentNode
        int largestIndex = parentIndex;
        int leftChild = (2 * parentIndex) + 1;
        int rightChild = (2 * parentIndex) + 2;

        //we check if leftChild exists and if it exists, we compare it to parentNode
        if(leftChild < arraySize - 1 && array[leftChild] >= array[parentIndex])
            largestIndex = leftChild; //point largest to leftChild index if leftChild is >= parentNode
            
        //we check if rightChild exists and if it exists, we compare it to leftChild
        if(rightChild < arraySize - 1 && array[leftChild] <= array[rightChild])
            largestIndex = rightChild;//point largest to rightChild index if rightChild >= leftChild
        
        //largest was initialized to parentIndex, if either childNodes >= parenNode, largest pointer would have been updated to either of their indexes
        if(largestIndex != parentIndex){
            //we swap the positions of the largest childNode and parentNode
            swap(array, parentIndex, largestIndex);
            //System.out.printf("largest value : %d",array[parentIndex]);
            //we call heapify recursively, where the new parentNode == array[LargestIndex];
            heapify(array, arraySize, largestIndex);
        }
        //if largestIndex was not updated, nothing to do
    }

    public static void swap(int array[], int x, int y){
        int temp;
        temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void printArray(int array[]){
            for(int i = 0 ; i < array.length; i++){
                System.out.printf("[%d] %d, ", i, array[i]);
            }
            System.out.println();
    }
}
