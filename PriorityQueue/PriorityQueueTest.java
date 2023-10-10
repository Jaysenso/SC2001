public class PriorityQueueTest{
    public static void main (String[] args){

        PriorityQueue queue = new PriorityQueue();

        for(int i = 0; i < 5; i++){
            Node node = new Node(i + 1, (i + 1j) * 2);
            queue.enqueue(node);
            System.out.println(queue.getQueueSize());
        }
        
        queue.printQueue();

    }
}