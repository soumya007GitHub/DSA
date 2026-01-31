class Solution {
    public List<String> findPath(int[][] grid) {
        List<String> answer = new ArrayList<>();
        if(grid[0][0] == 1){
            helper(0, 0, "", grid, answer);
        }
        return answer;
    }
    public void helper(int row, int column, String path, int[][] grid, List<String> answer){
        if(column == grid.length-1 && row == grid.length-1){
            answer.add(path);
            return;
        }
        grid[row][column] = -1;
            // left
            if(column-1>= 0 && grid[row][column-1] == 1){
                helper(row, column-1, path+"L", grid, answer);
            }
            // right
            if(column+1 < grid.length && grid[row][column+1] == 1){
                helper(row, column+1, path+"R", grid, answer);
            }
            // bottom
            if(row+1<grid.length && grid[row+1][column] == 1){
                helper(row+1, column, path+"D", grid, answer);
            }
            // top
            if(row-1>=0 && grid[row-1][column] == 1){
                helper(row-1, column, path+"T", grid, answer);
            }
        grid[row][column] = 1;
        return;
    }
}