#include <stdio.h>
#include <stdlib.h>

void mergeSort(int* array, int firstIndex, int lastIndex);
void printArray(int *array);


void main(){

    int arr[] = {7,5,6,10,9,1};
    int i;
    printf("%d",(3/2));

    //mergeSort(arr,arraySize);
    system("pause");
    
}

/*mergeSort algorithm
    • Declare left variable to 0 and right variable to n-1 
    • Find mid by medium formula. mid = (left+right)/2
    • Call merge sort on (left,mid)
    • Call merge sort on (mid+1,rear)
    • Continue till left is less than right
    • Then call merge function to perform merge sort.
*/
void mergeSort(int* array, int firstIndex, int lastIndex){
    
    //if lastIndex < 1 [there is only one element in the array, hence the array is already sorted]
    if((lastIndex - firstIndex) <= 0){
        return;
    }
    //find mid that will split the array into equal half
    int midPoint = (firstIndex + lastIndex) / 2;
    //merge sort on (left,mid)
    mergeSort(array, firstIndex, midPoint);
    //merge sort on (mid+1, rear)
    mergeSort(array, midPoint + 1, lastIndex);




    

}

void printArray(int *array){
    for(int i = 0; i < 6; i++){
        printf("%d ",array[i]);
    }
    printf("\n");
}
