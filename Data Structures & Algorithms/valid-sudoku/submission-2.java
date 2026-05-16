class Solution {

    public class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isValidSudoku(char[][] board) {
        List<List<Pair>> indices = new ArrayList<>();
        List<Pair> box1 = new ArrayList<>();
        int count = 0;
        int xStart = 0;
        int xEnd = 0;
        int yStart = 0;
        int yEnd = 3;
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                count = 0;
                xStart = xEnd;
                xEnd += 3;
                yStart = 0;
                yEnd = 3;
            }
            box1 = new ArrayList<>();
            box1.add(new Pair(xStart, xEnd));
            box1.add(new Pair(yStart, yEnd));
            indices.add(box1);
            yStart = yEnd;
            yEnd += 3;
        }
        boolean isValid = checkOriginalBoard(board);
        if (!isValid) {
            return isValid;
        }
        return checkSubBoards(indices, board);
    }

    public boolean checkOriginalBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> charSet1 = new HashSet<>();
            Set<Character> charSet2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c1 = board[i][j];
                if (c1 != '.' && !charSet1.add(board[i][j])) {
                    return false;
                }
                char c2 = board[j][i];
                if (c2 != '.' && !charSet2.add(board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkSubBoards(List<List<Pair>> indices, char[][] board) {
        for (int x = 0; x < indices.size(); x++) {
            List<Pair> indexList = indices.get(x);
            Set<Character> charSet = new HashSet();
            for (int i = indexList.get(0).x; i < indexList.get(0).y; i++) {
                for (int j = indexList.get(1).x; j < indexList.get(1).y; j++) {
                    char c = board[i][j];
                    if (c != '.' && !charSet.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
