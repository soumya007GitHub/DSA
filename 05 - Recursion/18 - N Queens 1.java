import java.util.Arrays;
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        helper(0, n, board, answer);
        return answer;
    }
    public void helper(int column, int total, char[][] board, List<List<String>> answer){
        if(column >= total){
            answer.add(combinator(board));
            return;
        }
        for(int row = 0; row<total; ++row){
            if(canWePlaceQueen(row, column, total, board)){
                board[row][column] = 'Q';
                helper(column+1, total, board, answer);
                board[row][column] = '.';
            }
        }
    }
    public boolean canWePlaceQueen(int row, int column, int total, char[][] board){
        // Same row check
        if(row >= 0 && row < total){
            for(int i = 0; i<total; ++i){
                if(board[row][i] == 'Q'){
                    return false;
                }
            }
        }
        // left top diagonal check
        if(row >= 0 && row<total && column >= 0 && column < total){
            int r = row-1;
            int c = column-1;
            while(r >= 0 && c >= 0){
                if(board[r][c] == 'Q'){
                    return false;
                }
                --r;
                --c;
            }
        }
        // left bottom diagonal check
        if(row >= 0 && row<total && column >= 0 && column < total){
            int r = row+1;
            int c = column-1;
            while(r < total && c >=  0){
                if(board[r][c] == 'Q'){
                    return false;
                }
                ++r;
                --c;
            }
        }
        return true;
    }
    public List<String> combinator(char[][] board){
        List<String> inner = new ArrayList<>();
        for(int i = 0; i<board.length; ++i){
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j<board.length; ++j){
                temp.append(board[i][j]);
            }
            inner.add(temp.toString());
        }
        return inner;
    }
}