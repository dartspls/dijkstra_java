import java.util.*;

/**
 * node
 */
public class Node implements Comparable<Node>{
    List<Edge> connections = new ArrayList<Edge>();
    int distance = 99999;
    String nodeID = "";

    public Node(String id) {
        nodeID = id;
    }

    /**
     * Connect two nodes with an edge
     * @param destination destination node
     */
    public void addEdge(Node destination, int distance) {
        Edge newEdge = new Edge(this, destination, distance);
        connections.add(newEdge);
        destination.receiveEdge(newEdge);
    }

    /**
     * Used when creating an edge between two nodes,
     * this is used for the destination edge
     * @param e edge to connect two nodes
     */
    public void receiveEdge(Edge e) {
        connections.add(e);
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}