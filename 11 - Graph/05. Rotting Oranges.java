class Pair{
    int i;
    int j;
    int time;
    Pair(int a, int b, int c){
        this.i = a;
        this.j = b;
        this.time = c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[i].length; ++j){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
            }
        }
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair current = q.remove();
            int r = current.i;
            int c = current.j;
            int time = current.time;

            answer = Math.max(answer, time);

            for (int d = 0; d < 4; d++) {
                int ni = r + di[d];
                int nj = c + dj[d];

                if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length &&
                    visited[ni][nj] != 2 && grid[ni][nj] == 1) {

                    visited[ni][nj] = 2;
                    q.add(new Pair(ni, nj, time + 1));
                }
            }
        }
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer;
    }
}

// TC - O(N*M)
// SC - O(N*M)