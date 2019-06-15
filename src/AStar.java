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
        for (Yal yal : source.getAdjacencies()) {
            if (!path.contains(yal.getTarget()) && yal.getCost() + yal.getTarget().getHeuristic() <= minValue) {
                minValue = yal.getCost() + yal.getTarget().getHeuristic();
                bestNode = yal.getTarget();
            }
        }
        path.add(bestNode);

        return computeNextNode(bestNode, target);
    }

}
