public class ShoretestPath {
    private int[][] board;
    private int[][] graph;

    public ShoretestPath() {
        initialize();
    }

    private void initialize() {
        board = new int[][]{
                {1, 0, -1},
                {0, 0, 2}
        };
        int height = board.length;
        int width = board[0].length;
        graph = new int[width * height][width * height];
        int h2 = graph.length;
        int w2 = graph[0].length;
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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == -1) {
                    for (int k = 0; k < h2; k++) {
                        graph[k][i * width + j] = 0;
                        graph[i * width + j][k] = 0;

                    }
                }
            }
        }
        for (int i = 0; i < h2; i++) {
            for (int j = 0; j < w2; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();

        }
        Node source = null;
        Node target = null;
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

        Node[] nodes = new Node[width * height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double heuristic = computeHuristic(targetX, targetY, i, j);
                nodes[i * width + j] = new Node(String.valueOf(i * width + j), heuristic);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                nodes[i * width + j] = new Node(String.valueOf(i * width + j));
            }
        }
        for (int i = 0; i < w2; i++) {
            for (int j = 0; j < w2; j++) {
                if (graph[i][j] == 1) {
                    nodes[i].addAdjacency(nodes[j], computeHuristic(i / width, i % width, j / width, j % width));
                }
            }
        }
        target = nodes[targetX * width + targetY];
        source = nodes[sourceX * width + sourceY];
        AStar a = new AStar();
        a.findShortestPath(source, target);
    }

    private double computeHuristic(int targetX, int targetY, int x, int y) {
        return Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
    }

    public static void main(String[] args) {
        ShoretestPath sp = new ShoretestPath();

    }
}
