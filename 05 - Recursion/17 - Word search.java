class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(int row, int column, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(index) || board[row][column] == '#') {
            return false;
        }

        char current = board[row][column];
        board[row][column] = '#';

        boolean found =
                helper(row - 1, column, index + 1, board, word) ||
                helper(row + 1, column, index + 1, board, word) ||
                helper(row, column - 1, index + 1, board, word) ||
                helper(row, column + 1, index + 1, board, word);

        board[row][column] = current;

        return found;
    }
}
