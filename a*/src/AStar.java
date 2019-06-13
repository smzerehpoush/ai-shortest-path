import java.util.ArrayList;
import java.util.List;

public class AStar {
    private List<Node> path = new ArrayList<>();

    public static void main(String[] args) {
        AStar a = new AStar();
        a.run();
    }

    public void run() {
        Node n1 = new Node("a");
        Node n2 = new Node("b");
        Node n3 = new Node("c");
        Node n4 = new Node("d");
        Node n5 = new Node("e");
        n1.addAdjacency(n2, 1);
        n1.addAdjacency(n3, 2);
        n1.addAdjacency(n4, 10);
        n1.addAdjacency(n5, 5);
        n2.addAdjacency(n1, 1);
        n2.addAdjacency(n3, 2);
        n2.addAdjacency(n4, 12);
        n2.addAdjacency(n5, 3);
        n3.addAdjacency(n1, 2);
        n3.addAdjacency(n2, 2);
        n3.addAdjacency(n4, 6);
        n3.addAdjacency(n5, 4);
        n4.addAdjacency(n1, 10);
        n4.addAdjacency(n2, 12);
        n4.addAdjacency(n3, 6);
        n4.addAdjacency(n5, 4);
        n5.addAdjacency(n1, 5);
        n5.addAdjacency(n2, 3);
        n5.addAdjacency(n3, 4);
        n5.addAdjacency(n4, 4);
        path.add(n1);
        computeNextNode(n1, n4);
    }

    private boolean computeNextNode(Node source, Node target) {
        System.out.print(source);

        if (source.equals(target))
            return true;
        else {
            System.out.print(" -> ");
        }
        double minValue = Double.POSITIVE_INFINITY;
        Node bestNode = null;
        for (Adjacency adjacency : source.getAdjacencies()) {
            if (!path.contains(adjacency.getTarget()) && adjacency.getCost() < minValue) {
                minValue = adjacency.getCost();
                bestNode = adjacency.getTarget();
            }
        }
        path.add(bestNode);

        return computeNextNode(bestNode, target);
    }

}
