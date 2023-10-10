



//Dijkstra Algorithm -> Local generality
//Algorithm Explanation
/*
 * 1. Initialize 3 different data structures 
 *  -> ArrayList Priority Queue
 *  -> 1D array "distArray" : dist[i] stores the distance to the sourceNode , "i" represents the node number 
 *  -> 2D array "adjMatrix" : adjMatrix[i][j] stores the weights of existing weights, where "i" represents the fromNode and "j" represents the toNode
 * 2. enqueue source node into queue and update dist[sourceNode] = 0
 * 3. call "extractCheapest" to extract the next cheapest adjacent neighbour node (delete the node at that index)
 * 4. check if dist(source -> nextNode) in distArray < dist(source -> currentNode) + dist(currentNode -> nextNode)
 * 5. we update distance(source -> nextNode) = dist(source -> currentNode) + dist(currentNode -> nextNode)
 * 6. enqueue nextNode with distance = newly updateddistance(source -> nextNode)
 * rinse and repeat 2 to 6 till the queue is empty
 */

public class PriorityQueueTest{
    public static void main (String[] args){

        //instantiate adjMatrix 
        int numOfVertices = 5;
        int inf = Integer.MAX_VALUE;
        int sourceNode = 1;

        PriorityQueue queue = new PriorityQueue();
        int[][] adjMatrix = new int[numOfVertices][numOfVertices];
        int[] distArray = new int[numOfVertices];
        int[] parent = new int[numOfVertices];

        //initialize weights between all vertices to INF
        for(int i = 0; i < numOfVertices; i++){
            for(int j = 0; j < numOfVertices; j++){
                adjMatrix[i][j] = inf;
                //weight between itself is 0
                if(i == j)
                    adjMatrix[i][j] = 0;
            }
        }
        //initialize distArray & parent Array
        for(int i = 0; i < numOfVertices; i++){
            distArray[i] = inf; 
            parent[i] = i + 1;
        }

        //add the edges & weights
        adjMatrix[0][1] = 4;
        adjMatrix[0][2] = 2;
        adjMatrix[0][3] = 6;
        adjMatrix[0][4] = 8;
        adjMatrix[1][3] = 4;
        adjMatrix[1][4] = 3;
        adjMatrix[2][3] = 1;
        adjMatrix[3][1] = 1;
        adjMatrix[3][4] = 3;
        
        printAdjMatrix(adjMatrix, numOfVertices);

        distArray[sourceNode - 1] = 0;
        queue.enqueue(sourceNode, 0);

        int weight;
        Edge cheapestEdge = null;
        int k = 0;
        //we keep processing the edges till the queue is empty(visited all the edges/vertices)
        while(k < 5){
            cheapestEdge = queue.extractCheapest(); //we extract the cheapest and enqueue its adjacent neighbours
            for(int i = 0; i < numOfVertices; i++){
                weight = adjMatrix[cheapestEdge.getNode() - 1][i];
                //we check if there exists a weights
                if(weight != inf && weight != 0 && distArray[i] > ){
                    queue.enqueue(i, weight);
                }
            }
            queue.printQueue();
            System.out.println();
            k++;
        }

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
    
}