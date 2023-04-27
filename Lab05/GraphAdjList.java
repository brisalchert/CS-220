//----------------------------------------------------------------------------------------------------------------------
//  GraphAdjList.java               Author: Brian Salchert
//
//  Simple Graph ADT for Integers using an adjacency list.
//----------------------------------------------------------------------------------------------------------------------

import java.util.HashMap;
import java.util.LinkedList;

public class GraphAdjList {
    HashMap<GraphNode, LinkedList<Adjacency>> graph;
    HashMap<Integer, GraphNode> nodeMap;

    /**
     * Constructor: Initializes the graph with a new HashMap and a HashMap from values to nodes
     */
    public GraphAdjList() {
        graph = new HashMap<>();
        nodeMap = new HashMap<>();
    }

    /**
     * Adds a new node with an empty adjacency list
     * @param value the value of the new node
     */
    public void addNode(int value) {
        GraphNode node = new GraphNode(value);
        LinkedList<Adjacency> adjList = new LinkedList<>();

        graph.put(node, adjList);
        nodeMap.put(value, node);
    }

    /**
     * Adds a new node with a given adjacency list from a two-dimensional array
     * @param value the value of the new node
     * @param adjacencies an array of ordered pairs containing adjacent nodes and their distances
     */
    public void addNode(int value, int[][] adjacencies) {
        GraphNode node = new GraphNode(value);

        for (int[] adjacency : adjacencies) {
            // Create an adjacency from the integer array
            Adjacency next = new Adjacency(nodeMap.get(adjacency[0]), adjacency[1]);

            // Add the adjacency to the node
            node.addAdjacency(next);
        }

        // Add the node to the HashMaps
        graph.put(node, node.getAdjacencies());
        nodeMap.put(value, node);
    }

    public void removeNode(int value) {
        GraphNode node = nodeMap.get(value);

        // Remove node adjacencies (0(n^2))
        for (GraphNode graphNode : graph.keySet()) {
            for (Adjacency adjacency : graph.get(graphNode)) {
                // If the adjacency goes to the removed node, remove it
                if (adjacency.getAdjNode() == node) {
                    // Remove the adjacency
                    graph.get(graphNode).remove(adjacency);
                }
            }
        }

        // Remove the node
        graph.remove(node);
        nodeMap.remove(value);
    }

    public void addAdjacency(int value, int adjValue, int distance) {
        GraphNode node = nodeMap.get(value);
        GraphNode adjNode = nodeMap.get(adjValue);
        Adjacency adjacency = new Adjacency(adjNode, distance);

        node.addAdjacency(adjacency);

        // Override the previous adjacency list
        graph.put(node, node.getAdjacencies());
    }

    /**
     * Checks if two nodes are adjacent (0(n))
     * @param value the value of the first node
     * @param adjValue the value of the adjacent node
     * @return true if the nodes are adjacent, false otherwise
     */
    public boolean isAdjacent(int value, int adjValue) {
        GraphNode node = nodeMap.get(value);
        GraphNode adjNode = nodeMap.get(adjValue);

        for (Adjacency adjacency : node.getAdjacencies()) {
            if (adjacency.getAdjNode() == adjNode) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the Adjacency object for an adjacency between two nodes, if it exists
     * @param value the value of the first node
     * @param adjValue the value of the adjacent node
     * @return the adjacency between the nodes
     */
    private Adjacency getAdjacency(int value, int adjValue) {
        if (isAdjacent(value, adjValue)) {
            for (Adjacency adjacency : graph.get(nodeMap.get(value))) {
                if (adjacency.getAdjNode() == nodeMap.get(adjValue)) {
                    return adjacency;
                }
            }
        }

        return null;
    }

    /**
     * Gets the distance between two adjacent nodes
     * @param value the value of the first node
     * @param adjValue the value of the second node
     * @return the distance between the nodes, or null if they are not adjacent
     */
    public Integer getDistance(int value, int adjValue) {
        if (isAdjacent(value, adjValue)) {
            return getAdjacency(value, adjValue).getDistance();
        }

        return null;
    }

    protected static class GraphNode {
        int node;
        LinkedList<Adjacency> adjacencies;

        /**
         * Constructor: Initializes the graph node with a node value and an adjacency list
         * @param node the node value
         */
        public GraphNode(int node) {
            this.node = node;
            this.adjacencies = new LinkedList<>();
        }

        /**
         * Accessor for the node value
         * @return the node value
         */
        public int getNode() {
            return node;
        }

        /**
         * Accessor for the node's adjacencies
         * @return the adjacency list
         */
        public LinkedList<Adjacency> getAdjacencies() {
            return adjacencies;
        }

        /**
         * Adds an adjacency to an existing node using another node and a distance
         * @param adjNode the adjacent node
         * @param distance the distance to the adjacent node
         */
        public void addAdjacency(GraphNode adjNode, int distance) {
            Adjacency forward = new Adjacency(adjNode, distance);
            Adjacency backward = new Adjacency(this, distance);


            // Add the adjacency to the node's adjacency list
            this.getAdjacencies().add(forward);

            // Add the adjacency to the other node's adjacency list
            adjNode.getAdjacencies().add(backward);
        }

        /**
         * Adds an adjacency to a node using an Adjacency object
         * @param adjacency the adjacency
         */
        public void addAdjacency(Adjacency adjacency) {
            // Add the adjacency to the node's adjacency list
            this.getAdjacencies().add(adjacency);

            GraphNode adjNode = adjacency.getAdjNode();
            int distance = adjacency.getDistance();

            Adjacency backward = new Adjacency(this, distance);

            // Add the adjacency to the other node's adjacency list
            adjNode.getAdjacencies().add(backward);
        }

        /**
         * Removes an adjacency between two existing nodes
         * @param adjNode the adjacent node
         */
        public void removeAdjacency(GraphNode adjNode) {
            // Remove the adjacency from the node's adjacency list
            this.getAdjacencies().remove(getAdjacency(this, adjNode));

            // Remove the adjacency from the other node's adjacency list
            adjNode.getAdjacencies().remove(getAdjacency(adjNode, this));
        }

        /**
         * Iterates through the adjacency list for a node until the correct adjacency is found (0(n))
         * @param node the current node
         * @param adjNode the adjacent node
         * @return the Adjacency object between the nodes, or null if it does not exist
         */
        public Adjacency getAdjacency(GraphNode node, GraphNode adjNode) {
            for (Adjacency adjacency : node.getAdjacencies()) {
                if (adjacency.getAdjNode() == adjNode) {
                    return adjacency;
                }
            }

            return null;
        }
    }

    protected static class Adjacency {
        GraphNode adjNode;
        int distance;

        /**
         * Constructor: Creates an Adjacency using the adjacent node and its distance
         * @param adjNode the adjacent node
         * @param distance the distance to the adjacent node
         */
        public Adjacency(GraphNode adjNode, int distance) {
            this.adjNode = adjNode;
            this.distance = distance;
        }

        /**
         * Accessor for the adjacent node
         * @return the adjacent node
         */
        public GraphNode getAdjNode() {
            return adjNode;
        }

        /**
         * Accessor for the distance of an adjacency
         * @return the distance
         */
        public int getDistance() {
            return distance;
        }
    }
}
