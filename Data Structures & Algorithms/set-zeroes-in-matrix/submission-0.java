class Solution {

    public class Pair {
        public Integer a;
        public Integer b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public void setZeroes(int[][] matrix) {
        List<Pair> eligibleIndices = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    Pair p = new Pair(i, j);
                    eligibleIndices.add(p);
                }
            }
        }
        for (Pair p : eligibleIndices) {
            for (int i = p.a - 1; i >= 0; i--) {
                matrix[i][p.b] = 0;
            }
            for (int i = p.a + 1; i < matrix.length; i++) {
                matrix[i][p.b] = 0;
            }
            for (int j = p.b - 1; j >= 0; j--) {
                matrix[p.a][j] = 0;
            }
            for (int j = p.b + 1; j < matrix[p.a].length; j++) {
                matrix[p.a][j] = 0;
            }
        }
    }
}
