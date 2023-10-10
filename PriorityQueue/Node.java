

public class Node{
    private int currentNode;
    //distance will be initialized to INT_MAX and gradually be updated with the shortest distance value
    private int distance; //distance between sourceNode -> CurrentNode 

    //constructor
    public Node(int currentNode, int distance){
        this.currentNode = currentNode;
        this.distance = distance;
    }

    //getters
    public int getCurrentNode(){
        return this.currentNode;
    }

    public int getDistance(){
        return this.distance;
    }


    public void printNodeInfo(){
        System.out.println("Current Node :" + currentNode + ", Shortestest Distance from source : "
        + distance + "\n");

    }

}
