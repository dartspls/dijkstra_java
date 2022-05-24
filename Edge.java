/**
 * edge
 */
public class Edge implements Comparable<Edge>{
    private int dist = 0;
    public int distance() {
        return dist;
    }
    public Node[] connections = new Node[2];
    public Edge(Node start, Node end, int dist) {
        connections[0] = start;
        connections[1] = end;
        this.dist = dist;
    }

    public Node destination(Node start) {
        if(connections[0].equals(start)) return connections[1];
        else return connections[0];
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.dist, other.dist);
    }
}