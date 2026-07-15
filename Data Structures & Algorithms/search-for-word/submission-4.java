class Solution {

    char[][] visitedBoard;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visitedBoard = new char[rows][cols];
        int row = 0;
        int col = 0;
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (doesWordExist(board, i, j, rows, cols, word, "", index)) {
                    return true;
                }
                visitedBoard = new char[rows][cols];
            }
        }
        return false;
    }

    private boolean doesWordExist(char[][]board, int row, int col, int rows, int cols, String word, String currWord, int index) {
        if (currWord.equals(word)) {
            return true;
        }
        if (row >= rows || col >= cols || row < 0 || col < 0 || currWord.length() >= word.length()) {
            return false;
        }
        if (visitedBoard[row][col] != '1') {
            visitedBoard[row][col] = '1';
            if (board[row][col] == word.charAt(index)) {
                boolean doesExist = false;
                doesExist = doesWordExist(board, row + 1, col, rows, cols, word, currWord + word.charAt(index), index + 1);
                if (doesExist) {
                    return true;
                }
                doesExist = doesWordExist(board, row - 1, col, rows, cols, word, currWord + word.charAt(index), index + 1);
                if (doesExist) {
                    return true;
                }
                doesExist = doesWordExist(board, row, col + 1, rows, cols, word, currWord + word.charAt(index), index + 1);
                if (doesExist) {
                    return true;
                }
                doesExist = doesWordExist(board, row, col - 1, rows, cols, word, currWord + word.charAt(index), index + 1);
                if (doesExist) {
                    return true;
                }
            }
            visitedBoard[row][col] = '0';
        }
        return false;
    }
}
