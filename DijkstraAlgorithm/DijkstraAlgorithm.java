import java.util.*;
/*
 * Algorithm Explanation [Dijkstra Algorithm -> Local generality]
 * 1. Initialize 3 different data structures 
 *  -> ArrayList Priority Queue
 *  -> 1D array "distArray" : dist[i] stores the distance to the sourceNode , "i" represents the node number 
 *  -> 2D array "adjMatrix" : adjMatrix[i][j] stores the weights of existing weights, where "i" represents the fromNode and "j" represents the toNode
 * 2. enqueue source node into queue and update dist[sourceNode] = 0
 * 3. call "extractCheapest" to extract the next cheapest adjacent neighbour node (delete the node at that index)
 * 4. check if dist(source -> nextNode) in distArray < dist(source -> currentNode) + dist(currentNode -> nextNode)
 * 5. we update distance(source -> nextNode) = dist(source -> currentNode) + dist(currentNode -> nextNode)
 * 6. enqueue nextNode with distance = newly updatedDistance(source -> nextNode)
 * rinse and repeat 2 to 6 till the queue is empty
*/

public class DijkstraAlgorithm{
    public static void main (String[] args){
        int numOfVertices = 5;
        int[][] adjMatrix = new int[numOfVertices][numOfVertices]; // 2D adjMatrix representation of the graph

        //initialize weights between all vertices to INF
        for(int i = 0; i < numOfVertices; i++){
            for(int j = 0; j < numOfVertices; j++){
                adjMatrix[i][j] = Integer.MAX_VALUE;
                //weight between itself is 0
                if(i == j)
                    adjMatrix[i][j] = 0;
            }
        }
        //Tutorial 6 graph 
        // adjMatrix[0][1] = 4;
        // adjMatrix[0][2] = 2;
        // adjMatrix[0][3] = 6;
        // adjMatrix[0][4] = 8;
        // adjMatrix[1][3] = 4;
        // adjMatrix[1][4] = 3;
        // adjMatrix[2][3] = 1;
        // adjMatrix[3][1] = 1;
        // adjMatrix[3][4] = 3;

        // second example
        adjMatrix[0][1] = 2;
        adjMatrix[0][3] = 1;
        adjMatrix[1][4] = 5;
        adjMatrix[1][2] = 4;
        adjMatrix[2][4] = 1;
        adjMatrix[3][2] = 3;

        printAdjMatrix(adjMatrix, numOfVertices);
        dijkstra(adjMatrix, 0, 4, numOfVertices);
    }



    public static void dijkstra(int [][] adjMatrix, int source, int destination, int numOfVertices){

        int inf = Integer.MAX_VALUE;
        PriorityQueue queue = new PriorityQueue(); // array-based priority queue to find shortest distance
        int[] distArray = new int[numOfVertices]; // stores the distance to the source Node
        int[] parent = new int[numOfVertices];//stores the parent node


        //initialize distArray & parent Array
        for(int i = 0; i < numOfVertices; i++){
            distArray[i] = inf;
            parent[i] = i;
        }
        distArray[source] = 0;
        queue.enqueue(source, 0);

        int cost, parentNode;
        Edge cheapestEdge = null;

        //we keep processing the edges till the queue is empty(visited all the edges/vertices)
        while(!queue.isEmpty()){
            cheapestEdge = queue.extractCheapest(); //we extract the cheapest
            if(cheapestEdge == null)
                break;

            //cheapestEdge.printNodeInfo(); <- to check what node has been popped off

            //we look for all its neighbours and cache the edge 
            for(int i = 0; i < numOfVertices; i++){ 
                cost = adjMatrix[cheapestEdge.getNode()][i];
                parentNode = cheapestEdge.getNode(); 

                //we look for a shortest path to its neighbour nodes, if there exists a shorter path, update distArray then enqueue it 
                if(cost != inf && cost != 0 && distArray[i] > adjMatrix[parentNode][i] + distArray[parentNode]){
                    distArray[i] = adjMatrix[parentNode][i] + distArray[parentNode]; // "i" represents neighbouring vertices
                    parent[i] = parentNode;
                    queue.enqueue(i, cost);
                }
            }
            //queue.printQueue(); <- to check queue at every iteration 
            //System.out.println();
            //printDistArray(distArray, numOfVertices);
        }
            printDistArray(distArray, numOfVertices);
            printPath(parent, 0, 4, numOfVertices);

    }


    public static void printAdjMatrix(int[][] adjacencyMatrix, int numOfVertices){

        System.out.println("---------------------------------------------");
        for(int i = 0; i < numOfVertices; i++){
            System.out.printf("\t%d",i + 1);
        }
        System.out.println("\n---------------------------------------------");


        for(int i = 0; i < numOfVertices; i++){
            System.out.printf("%d |", i + 1);
            for(int j = 0; j < numOfVertices; j++){
                if(adjacencyMatrix[i][j] == Integer.MAX_VALUE){
                    char inf = '\u221E';
                    System.out.printf("\t%c",inf);
                }
                else
                    System.out.printf("\t%d",adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void printDistArray(int [] distArray, int numOfVertices){
            System.out.printf("\n----------Distance Array----------\n");

            System.out.printf("Node\t|\t");
            for(int i = 0; i < numOfVertices; i++){
                System.out.printf("%d\t",i + 1);
            }

            System.out.println();

            System.out.printf("Distance|\t");
            for(int i = 0; i < numOfVertices; i++){
                System.out.printf("%d\t",distArray[i]);
            }
            System.out.println();
    }

    public static void printPath(int[] parent, int source, int destination, int numOfVertices){

        ArrayList<Integer> path = new ArrayList<Integer>();
        int node = destination;
        //we backtrack the parentArray and add the parentNode to an ArrayList "path" for printing
        while(parent[node] != source){
            path.add(parent[node]);
            node = parent[node];
        }
        //since we know destination and source, we just print out all the vertices in between those 2 vertices
        System.out.printf("%d -> " , source + 1);

        for(int j = path.size() - 1; j >= 0; j--){
            System.out.printf("%d", (path.get(j) + 1));
            if(j > 0)
                System.out.printf(" -> ");
        }
        System.out.printf(" -> %d" , destination + 1);
    }
    
}