package Graph;

public class Cycle {

    private boolean hasCycle = false;
    private boolean[] visited;
    
    public Cycle(Graph g) {
        visited = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(g, i, i);
            }
        }
    }
    
    public void dfs(Graph g, int v, int u) {
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(g, w, v);
            }
            else if (w != u) hasCycle = true;
        }
    }
    
    public boolean hasCycle () {
        return hasCycle;
    }
}
