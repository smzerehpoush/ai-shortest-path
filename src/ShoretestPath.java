public class ShoretestPath {
    private int[][] board;
    private int[][] graph;
    private int width;
    private int height;

    public ShoretestPath(int[][] board) {
        this.board = board;
    }

    private void fillGraph1s() {
        int n = -1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                try {
                    n = (i) * width + (j - 1);
                    graph[i * width + j][n] = 1;
                    graph[n][i * width + j] = 1;
                } catch (Exception ignored) {
                }
                try {
                    n = (i - 1) * width + (j);
                    graph[i * width + j][n] = 1;
                    graph[n][i * width + j] = 1;
                } catch (Exception ignored) {
                }
                try {
                    n = (i) * width + (j + 1);
                    graph[i * width + j][n] = 1;
                    graph[n][i * width + j] = 1;
                } catch (Exception ignored) {
                }
                try {
                    n = (i + 1) * width + (j);
                    graph[i * width + j][n] = 1;
                    graph[n][i * width + j] = 1;
                } catch (Exception ignored) {
                }

            }

        }

    }

    private void fillGraph0s() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == -1) {
                    for (int k = 0; k < width * height; k++) {
                        graph[k][i * width + j] = 0;
                        graph[i * width + j][k] = 0;

                    }
                }
            }
        }
    }

    private void fillGraph() {
        graph = new int[width * height][width * height];
        fillGraph1s();
        fillGraph0s();

    }

    private void printGraph(int[][] graph) {
        int width = graph[0].length;
        int height = graph.length;
        for (int[] row : graph) {
            for (int col : row) {
                System.out.print(col + " ");

            }
            System.out.println();
        }
        System.out.println();
    }

    private int[] computeSourceAndTargetCoordinate() {
        int sourceX = -1;
        int sourceY = -1;
        int targetX = -1;
        int targetY = -1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                } else if (board[i][j] == 1) {
                    sourceX = i;
                    sourceY = j;
                }

            }
        }
        if (sourceX == -1 || sourceY == -1 || targetX == -1 || targetY == -1)
            throw new IllegalStateException("must have source and target.");

        int[] output = new int[4];
        output[0] = sourceX;
        output[1] = sourceY;
        output[2] = targetX;
        output[3] = targetY;
        return output;
    }

    private void run() {
        height = board.length;
        width = board[0].length;
        fillGraph();
        System.out.println("board :");
        printGraph(board);
        System.out.println("graph :");
        printGraph(graph);
        int[] result = computeSourceAndTargetCoordinate();
        int sourceX = result[0];
        int sourceY = result[1];
        int targetX = result[2];
        int targetY = result[3];
        Node[] nodes = buildNodes(targetX, targetY);
        Node target = nodes[targetX * width + targetY];
        Node source = nodes[sourceX * width + sourceY];
        AStar algorithm = new AStar();
        algorithm.findShortestPath(source, target);
    }

    private Node[] buildNodes(int targetX, int targetY) {
        Node[] nodes = new Node[width * height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double heuristic = computeDistance(targetX, targetY, i, j);
                nodes[i * width + j] = new Node(String.valueOf(i * width + j), heuristic);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                nodes[i * width + j] = new Node(String.valueOf(i * width + j));
            }
        }
        for (int i = 0; i < width * height; i++) {
            for (int j = 0; j < width * height; j++) {
                if (graph[i][j] == 1) {
                    nodes[i].addAdjacency(nodes[j], computeDistance(i / width, i % width, j / width, j % width));
                }
            }
        }
        return nodes;
    }

    private double computeDistance(int targetX, int targetY, int x, int y) {
        return Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, -1},
                {1, 0, 2}
        };
        ShoretestPath sp = new ShoretestPath(board);
        sp.run();

    }
}
