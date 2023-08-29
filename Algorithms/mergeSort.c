#include <stdio.h>
#include <stdlib.h>
#define SIZE 8
void mergeSort(int* array, int firstIndex, int lastIndex);
void merge(int *array, int firstIndex, int midPoint, int lastIndex);
void printArray(int *array);


void main(){

    int arr[] = {90,25,10,71,94,22,59,74};
    int i;

    printArray(arr);
    mergeSort(arr,0,SIZE-1);
    printArray(arr);

    
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

    merge(array, firstIndex, midPoint, lastIndex);
}
/*
    Merge algorithm:
        1. left subarray runs from n to 'midpoint' with a as running index;
        2. right subarray runs from midpoint + 1 to m with b as running index
        3. slot[a] is the head element in left subarray, slot[b] is the head element in right subarray
        4. d
*/
void merge(int *array, int firstIndex, int midPoint, int lastIndex){

    int temp;
    int a = firstIndex;
    int b = midPoint + 1;
    int i;
    
    while(a <= midPoint && b <= lastIndex){
        //case 1 : where slot[a]>slot[b] we need to perform right-shift 
        if(array[a] > array[b]){ 
            temp = array[b];
            //right-shift
            for(i = ++midPoint; i > a; i--){
                array[i] = array[i-1];
            }
            //insert slot[b] behind of slot[a]
            array[a++] = temp;
            //increment b pointer/index
            b++;
        }
        //case 3: where slot[a] == slot[b] we will perform right-shift and slot slot[b] right beside slot[a]
        else if(array[a] == array[b]){
            temp = array[b];
            //increment a to make space for slot[b]
            a++;
            for(i = ++midPoint; i > a; i--){
                array[i] = array[i-1];
            }
            array[a++] = temp;
            //increment b pointer/index
            b++;
        }
        //case 2: where slot[a] < slot[b] trivial case nothing much to do 
        else if(array[a] < array[b]){
            a++;
        }
    }

}

void printArray(int *array){
    for(int i = 0; i < SIZE; i++){
        printf("%d ",array[i]);
    }
    printf("\n");
}
