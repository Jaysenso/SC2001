#include <stdio.h>
#include <stdlib.h>
//instantiate functions
void insertionSort(int *array);

void main(){
    //instantiate array
    int array[] = {5,4,3,2,1};

    //print the unsorted array
    printf("before insertion sort:\n");
    for(int x = 0; x < 5; x++){
        printf("%d ",array[x]);
    }

    //sort function
    insertionSort(array);
    printf("\n");

    //print the sorted array
    printf("after insertion sort:\n");
    for(int i = 0; i < 5;i++){
        array[i];
        printf("%d ",array[i]);
    }

    printf("\n");   
    system("pause");
}


//split the list into sorted and unsorted
//i will be my marker that seperate the 2 different lists
//j will be my key comparison "pointer"
void insertionSort(int* array){
    int i,j;
    int temp;
    //we move the market down the list
    for(i = 1; i <= 5; i++){
        //j will loop the opposite direction and perform key comparison
        for(j = i; j > 0; j--){
            //if the right number > left number (we will swap the order)
            if(array[j] < array[j-1]){
                temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
            else
                continue;
        }
    }
}

