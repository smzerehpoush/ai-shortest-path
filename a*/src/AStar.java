import java.util.ArrayList;
import java.util.List;

public class AStar {
    private List<Node> path = new ArrayList<>();

    public static void main(String[] args) {
        AStar a = new AStar();
        Graph graph = new Graph();
        a.run(graph);
    }

    public void run(Graph graph) {

        path.add(graph.getSource());
        computeNextNode(graph.getSource(), graph.getTarget());
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
            if (!path.contains(adjacency.getTarget()) && adjacency.getCost() + adjacency.getTarget().getHeuristic() < minValue) {
                minValue = adjacency.getCost() + adjacency.getTarget().getHeuristic();
                bestNode = adjacency.getTarget();
            }
        }
        path.add(bestNode);

        return computeNextNode(bestNode, target);
    }

}
