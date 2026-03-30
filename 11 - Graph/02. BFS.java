class Solution {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
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
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        helperBFS(answer, graph, visited, q);
        return answer;
    }
    public void helperBFS(List<Integer> answer, List<List<Integer>> graph, boolean[] visited, Queue<Integer> q){
        while(!q.isEmpty()){
            int current = q.remove();
            answer.add(current);
            for(int i:graph.get(current)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}

// TC - O(V+E)
// SC - O(V+E)

