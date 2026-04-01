class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i<n; ++i){
            if(!visited[i]){
                dfs(i, visited, isConnected);
                answer += 1;
            }
        }
        return answer;
    }
    public void dfs(int i, boolean[] visited, int[][] isConnected){
        visited[i] = true;
        for (int j = 0; j<isConnected.length; ++j) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, visited, isConnected);
            }
        }
    }
}

// TC - O(N^2)
// SC - O(N)