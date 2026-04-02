class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        for(int i = 0; i<image.length; ++i){
            for(int j = 0; j<image[i].length; ++j){
                visited[i][j] = image[i][j];
            }
        }
        int initialColor = image[sr][sc];
        visited[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while(!q.isEmpty()){
            int row = q.peek().i;
            int column = q.peek().j;
            
            int nextRow[] = {row-1, row, row+1, row};
            int nextCol[] = {column, column-1, column, column+1};

            Pair current = q.remove();

            for(int i = 0; i<4; ++i){
                if(nextRow[i] >= 0 && nextRow[i] < image.length && nextCol[i] >= 0 && nextCol[i] < image[0].length){
                    if(image[nextRow[i]][nextCol[i]] == initialColor && visited[nextRow[i]][nextCol[i]] != color){
                        visited[nextRow[i]][nextCol[i]] = color;
                        q.add(new Pair(nextRow[i], nextCol[i]));
                    }
                }
            }
        }
        return visited;
    }
}

// TC - O(m*n)
// SC - O(m*n)