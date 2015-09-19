package Graph;

public class TwoColor {

    private boolean[] visited;
    private boolean[] color;
    private boolean isTwoColorable = true;
    
    public TwoColor(Graph g){
        visited = new boolean[g.V()];
        color = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(g, i);
            }
        }
    }
    
    public void dfs(Graph g, int v) {
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                color[w] = !color[v];
                dfs(g, w);
            }
            else if (color[w] == color[v]) isTwoColorable = false;
        }
    }
    
    public boolean isBipartite() {
        return isTwoColorable;
    }
}
