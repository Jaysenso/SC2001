 

public class Edge{
    private int node;
    //distance will be initialized to INT_MAX and gradually be updated with the shortest distance value
    private int distance; //distance between sourceNode -> CurrentNode 

    //constructor
    public Edge(int node, int distance){
        this.node = node;
        this.distance = distance;
    }

    //getters
    public int getNode(){
        return this.node;
    }


    public int getDistance(){
        return this.distance;
    }


    public void printNodeInfo(){
        System.out.println("Current Node :" + node + ", Shortest Distance from source : "
        + distance + "\n");

    }

}
