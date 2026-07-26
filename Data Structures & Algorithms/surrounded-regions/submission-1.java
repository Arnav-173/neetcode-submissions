class Solution {

    class Pair {
        public int i;
        public int j;

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


    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'X') {
                    Set<Pair> visited = new HashSet<>();
                    boolean isSurrounded = surround(board, i, j, visited);
                    if (isSurrounded)
                        board[i][j] = 'X';
                }
            }
        }
    }

    private boolean surround(char[][]board, int i, int j, Set<Pair> visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == 'X') {
            return true;
        }
        Pair p = new Pair(i, j);
        if (visited.contains(p)) {
            return true;
        }
        boolean isSurrounded = true;
        visited.add(p);
        if (isSurrounded) {
            isSurrounded = surround(board, i + 1, j, visited);
        } else {
            return false;
        }
        if (isSurrounded) {
            isSurrounded = surround(board, i - 1, j, visited);
        } else {
            return false;
        }
        if (isSurrounded) {
            isSurrounded = surround(board, i, j + 1, visited);
        } else {
            return false;
        }
        if (isSurrounded) {
            isSurrounded = surround(board, i, j - 1, visited);
        } else {
            return false;
        }
        return isSurrounded;
    }
}
