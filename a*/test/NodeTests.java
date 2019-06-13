import org.junit.Test;

public class NodeTests {
    @Test
    public void buildNodes() {
        int size = 5;
        for (int i = 1; i <= size; i++) {
            System.out.println("Node n" + i + " = new Node(\"" + (char) ('a' + (i - 1)) + "\");");
        }
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i != j)
                    System.out.println("n" + i + ".addAdjacency(n" + j + ",);");


            }
        }
    }
}
