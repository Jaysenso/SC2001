
import java.util.*;

public class PriorityQueue {
    
    //array will be our dataStructure of choice to implement priority queue
    //this array will store datatype "Edge" that stores the name of the node & the distance to
    //source node. This will act as a priority queue as well as a data structure to store/update shortest distance
    private final ArrayList<Edge> queue;

    //constructor
    public PriorityQueue(){
        this.queue = new ArrayList<Edge>();
    }

    public Edge extractCheapest(){
        if(queue.isEmpty())
            return null;

        int cheapestIndex = -1; //act as a flag to signal that we found the cheapestEdge and for deletion/dequeue
        int distance = Integer.MAX_VALUE;

        //we iterate through the queue looking for the smallest distance
        Edge cheapestEdge = null;
        for(int i = 0; i < queue.size(); i++){
            //if we found a cheaper distance cost, we update cheapestEdge
            if(queue.get(i).getDistance() < distance){
                distance = queue.get(i).getDistance();
                cheapestIndex = i;
                cheapestEdge = queue.get(i);
            }
        }
        //if cheapestIndex was updated, we found the cheapestEdge
        if(cheapestIndex != -1)
            queue.remove(cheapestIndex);

        return cheapestEdge;
    }

    //PriorityQueue functions
    public void enqueue(int node, int distance){
        queue.add(new Edge(node, distance));
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }


    //print Queue
    public void printQueue(){
        
        if(queue.isEmpty()){
            System.out.println("The queue is empty!");
            return;
        }
        Edge edge = null;
        
        System.out.println();
        System.out.print("To Node:\t|\t");
        for (Edge value : queue) {
            edge = value;
            System.out.printf("%d\t", edge.getNode() + 1);
        } 
        System.out.println();

        System.out.print("Distance:\t|\t");
        for (Edge value : queue) {
            edge = value;
            if (edge.getDistance() == Integer.MAX_VALUE) {
                char inf = '\u221E';
                System.out.printf("%c\t", inf);
            } else
                System.out.printf("%d\t", edge.getDistance());
        }
        System.out.println();
    }
}

