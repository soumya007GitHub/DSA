class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        return helper(0, n, board);
    }
    public int helper(int column, int total, char[][] board){
        if(column >= total){
            return 1;
        }
        int count = 0;
        for(int row = 0; row<total; ++row){
            if(canWePlaceQueen(row, column, total, board)){
                board[row][column] = 'Q';
                count += helper(column+1, total, board);
                board[row][column] = '.';
            }
        }
        return count;
    }
    public boolean canWePlaceQueen(int row, int column, int total, char[][] board){
        // row check
        if(row >= 0 && row < total && column >= 0 && column < total){
            for(int i = column-1; i>=0; --i){
                if(board[row][i] == 'Q'){
                    return false;
                }
            }
        }
        // top left diagonal
        if(row >= 0 && row < total && column >= 0 && column < total){
            int r = row;
            int c = column;
            while(r >= 0 && c >= 0){
                if(board[r][c] == 'Q'){
                    return false;
                }
                --r;
                --c;
            }
        }
        // bottom left diagonal
        if(row >= 0 && row < total && column >= 0 && column < total){
            int r = row;
            int c = column;
            while(r < total && c >= 0){
                if(board[r][c] == 'Q'){
                    return false;
                }
                ++r;
                --c;
            }
        }
        return true;
    }
}