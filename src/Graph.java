import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;
    private Node source;
    private Node target;

    public Graph() {
        nodes = new ArrayList<>();
        initialize();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }

    private void initialize() {
        Node n1 = new Node("a", 0);
        Node n2 = new Node("b", 6);
        Node n3 = new Node("c", 1);
        Node n4 = new Node("d", 100);
        Node n5 = new Node("e", 1);
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
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        source = n1;
        target = n4;
    }
}
