import java.util.ArrayList;
import java.util.List;

public class AStar {
    private List<Node> path;

    public List<Node> findShortestPath(Node source, Node target) {
        path = new ArrayList<>();
        path.add(source);
        return computeNextNode(source, target);
    }

    private List<Node> computeNextNode(Node source, Node target) {
        System.out.print(source);

        if (source.equals(target))
            return path;
        else {
            System.out.print(" -> ");
        }
        double minValue = Double.POSITIVE_INFINITY;
        Node bestNode = null;
        for (Adjacency adjacency : source.getAdjacencies()) {
            if (!path.contains(adjacency.getTarget()) && adjacency.getCost() + adjacency.getTarget().getHeuristic() <= minValue) {
                minValue = adjacency.getCost() + adjacency.getTarget().getHeuristic();
                bestNode = adjacency.getTarget();
            }
        }
        path.add(bestNode);

        return computeNextNode(bestNode, target);
    }

}
