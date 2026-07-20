class Solution {

    class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Pair p = (Pair) obj;

            return i == p.i && j == p.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }


    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<Pair> unvisited = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {        
                if (grid[i][j] == 0) {
                    performBFS(grid, i, j);
                }
            }
        }       
    }
    
    private void performBFS(int[][] grid, int x, int y) {
        Queue<Pair> bfsQueue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int cols = grid[0].length;
        bfsQueue.add(new Pair(x, y));
        while (!bfsQueue.isEmpty()) {
            Pair p = bfsQueue.poll();
            int i = p.i;
            int j = p.j;
            if (visited[i][j] != 1) {
                visited[i][j] = 1;
                if (isValidNeighbour(i + 1, j, rows, cols, grid)) {
                    if (grid[i + 1][j] != 0 && grid[i + 1][j] > grid[i][j] + 1) {
                        grid[i + 1][j] = grid[i][j] + 1;
                    }
                    bfsQueue.add(new Pair(i + 1, j));
                }
                if (isValidNeighbour(i, j - 1, rows, cols, grid)) {
                    if (grid[i][j - 1] != 0 && grid[i][j  - 1] > grid[i][j] + 1) {
                        grid[i][j - 1] = grid[i][j] + 1;
                    }
                    bfsQueue.add(new Pair(i, j - 1));
                }
                if (isValidNeighbour(i - 1, j, rows, cols, grid)) {
                    if (grid[i - 1][j] != 0 && grid[i - 1][j] > grid[i][j] + 1) {
                        grid[i - 1][j] = grid[i][j] + 1;
                    }
                    bfsQueue.add(new Pair(i - 1, j));
                }
                if (isValidNeighbour(i, j + 1, rows, cols, grid)) {
                    if (grid[i][j + 1] != 0 && grid[i][j + 1] > grid[i][j] + 1) {
                        grid[i][j + 1] = grid[i][j] + 1;
                    }
                    bfsQueue.add(new Pair(i, j + 1));
                }
            }
        }
    }

    private boolean isValidNeighbour(int i, int j, int rows, int cols, int[][] grid) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }
        if (grid[i][j] == -1) {
            return false;
        }
        return true;
    }

}
