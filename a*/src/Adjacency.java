public class Adjacency {
    private Node source;
    private Node target;
    private Integer cost;

    public Adjacency(Node source, Node target, Integer cost) {
        this.source = source;
        this.target = target;
        this.cost = cost;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }

    public Integer getCost() {
        return cost;
    }
}
