
import java.util.*;

public class PriorityQueue {
    
    //array will be our dataStructure of choice to implement priority queue
    //this array will store datatype "node" that stores the name of the node & the distance to
    //source node. This will act as a priority queue as well as a data structure to store/update shortest distance
    private ArrayList<Node> queue;


    //constructor
    public PriorityQueue(){
        this.queue = new ArrayList<Node>();
    }

    //typical PriorityQueue functions
    public void enqueue(Node node){
        if (node == null)
            System.out.println("Invalid Node!");
        
        queue.add(node);
    }

    //getters
    public int getQueueSize(){
        return queue.size();
    }

    public void printQueue(){
        if(queue.size() == 0)
            System.out.println("The queue is empty!");


        Node node = null;

        System.out.printf("Current Node:\t|\t");
        for(int i = 0; i < queue.size(); i++){
            node = queue.get(i);
            System.out.printf("%d\t",node.getCurrentNode());
        } 

        System.out.println();

        System.out.printf("Distance:\t|\t");
        for(int i = 0; i < queue.size(); i++){
            node = queue.get(i);
            System.out.printf("%d\t", node.getDistance());
        }
        System.out.println();
    }
}

