class Solution {

    class Pair {
        public int i;
        public int j;
        public boolean hasPathToPacific = false;
        public boolean hasPathToAtlantic = false;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return this.i == p.i && this.j == p.j;
        }
        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Set<Pair> result = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Pair p = new Pair(i, j);
                Set<Pair> visited = new HashSet<>();
                searchPathToOcean(heights, i, j, rows, cols, heights[i][j], p, visited);
                if (p.hasPathToPacific == true && p.hasPathToAtlantic == true) {
                    result.add(p);
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (Pair p : result) {
            List<Integer> list = new ArrayList<>();
            list.add(p.i);
            list.add(p.j);
            resultList.add(list);
        }
        return resultList;
    }

    public void searchPathToOcean(int[][]heights, int i, int j, int rows, int cols, int val, Pair p, Set<Pair> visited) {
        if ((i < 0 && j >= 0 && j < cols) || (j < 0 && i >= 0 && i < rows)) {
            p.hasPathToPacific = true;
            return;
        }
        if ((j >= cols && i >=0 && i < rows) || (i >= rows && j >= 0 && j < cols)) {
            p.hasPathToAtlantic = true;
            return;
        }
        if (i < 0 || j < 0 || i > rows || j > cols || heights[i][j] > val) {
            return;
        }
        Pair currentPair = new Pair(i, j);
        if (visited.contains(currentPair)) {
            return;
        }
        visited.add(currentPair);
        searchPathToOcean(heights, i + 1, j, rows, cols, heights[i][j], p, visited);
        searchPathToOcean(heights, i - 1, j, rows, cols, heights[i][j], p, visited);
        searchPathToOcean(heights, i, j + 1, rows, cols, heights[i][j], p, visited);
        searchPathToOcean(heights, i, j - 1, rows, cols, heights[i][j], p, visited);
    }
}
