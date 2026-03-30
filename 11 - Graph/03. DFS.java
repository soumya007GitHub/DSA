class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
      List<Integer> answer = new ArrayList<>();
      List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<V; ++i){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> inner:adj){
            int u = inner.get(0);
            int v = inner.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        visited[0] = true;
        helperDFS(answer, graph, visited, 0);
        return answer;
    }
    public void helperDFS(List<Integer> answer, List<List<Integer>> graph, boolean[] visited, int current){
        visited[current] = true;
        answer.add(current);
        for(int i:graph.get(current)){
            if(!visited[i]){
                helperDFS(answer, graph, visited, i);
            }
        }
    }
}

// TC - O(V+E)
// SC - O(V+E)

