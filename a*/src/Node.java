import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    public Node(String name) {
        this(name, 0);
    }

    public Node(String name, int heuristic) {
        this.name = name;
        this.heuristic = heuristic;
        this.adjacencies = new ArrayList<>();
    }

    private String name;
    private Integer heuristic;
    private List<Adjacency> adjacencies;

    public List<Adjacency> getAdjacencies() {
        return adjacencies;
    }

    void addAdjacency(Node target, int cost) {
        Adjacency adjacency = new Adjacency(this, target, cost);
        adjacencies.add(adjacency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
