public class Adjacency {
    private Node source;
    private Node target;
    private double cost;

    public Adjacency(Node source, Node target, double cost) {
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

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "{" + this.getSource() + "-" + this.getTarget() + ":" + this.getCost() + "}";
    }
}
