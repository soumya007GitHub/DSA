class Solution {
    public int answer = 0;
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for(List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for(int i = 0; i<V; ++i){
            if(!visited[i]){
                dfs(i, visited, graph);
                answer += 1;
            }
        }
        return answer;
    }
    public void dfs(int current, boolean[] visited, List<List<Integer>> graph){
        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }
}

// TC - O(V+E)
// SC - O(V+E)