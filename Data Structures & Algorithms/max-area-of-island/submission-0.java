class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, rows, cols);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][]grid, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i - 1, j, rows, cols);
        area += dfs(grid, i + 1, j, rows, cols);
        area += dfs(grid, i, j + 1, rows, cols);
        area += dfs(grid, i, j - 1, rows, cols);
        return area;
    }
}
