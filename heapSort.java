public class heapSort {
    public static void main(String[] args){
        int[] array = new int[]{3,2,1};
        printArray(array);

    }
    public static void heapify(int[] array){
        int root = array[0];
        int level = 1;
        int left = level * 2;
        int right = (level * 2) + 1; 
        int largestValue = -1;
        largestValue = left < right ? right : left;
        if(largestValue < root)
            largestValue = root;
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
