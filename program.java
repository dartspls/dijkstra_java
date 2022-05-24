import java.util.*;
/**
 * program
 */
public class program {
    static Node[] allNodes;
    // static List<Node> visitedNodes = new ArrayList<Node>();
    static Queue<Node> p = new PriorityQueue<Node>();
    public static void main(String[] args) {
        allNodes = new Node[] {
            new Node("A"), // 0
            new Node("B"), // 1
            new Node("C"), // 2
            new Node("D"), // 3
            new Node("E"), // 4
            new Node("F"), // 5
            new Node("G")  // 6
        };

        allNodes[0].addEdge(allNodes[1], 4);    // A <-> B
        allNodes[0].addEdge(allNodes[2], 3);    // A <-> C
        allNodes[0].addEdge(allNodes[4], 7);    // A <-> E
        allNodes[1].addEdge(allNodes[3], 5);    // B <-> D
        allNodes[1].addEdge(allNodes[2], 6);    // B <-> C
        allNodes[2].addEdge(allNodes[3], 11);   // C <-> D
        allNodes[2].addEdge(allNodes[4], 8);    // C <-> E
        allNodes[3].addEdge(allNodes[4], 2);    // D <-> E
        allNodes[3].addEdge(allNodes[5], 2);    // D <-> F
        allNodes[3].addEdge(allNodes[6], 10);   // D <-> G
        allNodes[4].addEdge(allNodes[6], 5);    // E <-> G
        allNodes[5].addEdge(allNodes[6], 3);    // F <-> G

        Node startNode = allNodes[0];
        startNode.distance = 0;




        for(Node n : allNodes){
            p.add(n);
        }

        int countBreak = 0;
        while(!p.isEmpty()) {
            countBreak++;
            Node n = p.poll();
            for(Edge e : n.connections) {
                int calculatedDistance = e.distance() + n.distance;
                if(e.destination(n).distance > calculatedDistance) {
                    e.destination(n).distance = calculatedDistance;
                    System.out.println(e.destination(n).nodeID);
                }
            }
            if(countBreak >= 5000) {
                System.out.println("Exceeded 5,000 iterations, breaking.");
                break;
            }
        }
        System.out.println("Iterations: " + countBreak);
        for(Node n : allNodes) {
            System.out.println("Node: " + n.nodeID + " distance: " + n.distance);
        }
    }
}