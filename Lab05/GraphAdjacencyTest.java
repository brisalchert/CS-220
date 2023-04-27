//----------------------------------------------------------------------------------------------------------------------
//  GraphAdjacencyTest.java             Author: Brian Salchert
//
//  Driver class for testing the Integer Graph implementation with Adjacency Lists.
//----------------------------------------------------------------------------------------------------------------------

public class GraphAdjacencyTest {
    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList();

        // Add nodes
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        // Add adjacencies
        graph.addAdjacency(1, 2, 10);
        graph.addAdjacency(1, 3, 15);
        graph.addAdjacency(1, 4, 20);
        graph.addAdjacency(2, 3, 35);
        graph.addAdjacency(2, 4, 25);
        graph.addAdjacency(3, 4, 30);

        // Output the distance between nodes 2 and 3
        System.out.println("Distance between 2 and 3: " + graph.getDistance(2, 3));

        // Delete node 3
        graph.removeNode(3);

        // Output the distance between nodes 2 and 3 again (should be null)
        System.out.println("Distance between 2 and 3: " + graph.getDistance(2, 3));
    }
}
