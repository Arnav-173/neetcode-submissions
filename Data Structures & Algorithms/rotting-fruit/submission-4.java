class Solution {
    class Pair {
        public int i;
        public int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Stack<Queue<Pair>> queueStack = new Stack<>();
        Queue<Pair> rottenSources = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottenSources.add(new Pair(i, j));
                }
            }
        }
        queueStack.push(rottenSources);
        int minutes = performBFS(queueStack, grid);
        boolean rottenFruitRemains = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rottenFruitRemains = true;
                    break;
                }
            }
        }
        if (rottenFruitRemains) {
            return -1;
        }
        return minutes;
    }

    private int performBFS(Stack<Queue<Pair>> queueStack, int[][]grid) {
        int minutes = 0;
        while (!queueStack.isEmpty()) {
            Queue<Pair> rotten = queueStack.pop();
            Queue<Pair> willRotNext = new LinkedList<>();
            while (!rotten.isEmpty()) {
                Pair rot = rotten.poll();
                int i = rot.i;
                int j = rot.j;
                if (willNeigbourRot(i + 1, j, grid)) {
                    grid[i + 1][j] = 2;
                    willRotNext.add(new Pair(i + 1, j));
                }
                if (willNeigbourRot(i - 1, j, grid)) {
                    grid[i - 1][j] = 2;
                    willRotNext.add(new Pair(i - 1, j));
                }
                if (willNeigbourRot(i, j + 1, grid)) {
                    grid[i][j + 1] = 2;
                    willRotNext.add(new Pair(i, j + 1));
                }
                if (willNeigbourRot(i, j - 1, grid)) {
                    grid[i][j - 1] = 2;
                    willRotNext.add(new Pair(i, j - 1));
                }
            }
            if (!willRotNext.isEmpty()) {
                queueStack.push(willRotNext);
            }
            minutes++;
        }
        return minutes - 1;
    }

    private boolean willNeigbourRot(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 2 || grid[i][j] == 0) {
            return false;
        }
        return true;
    }
}
