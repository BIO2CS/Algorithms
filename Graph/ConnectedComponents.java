package Graph;

public class ConnectedComponents {

    private boolean[] visited;
    private int[] id;
    private int count;
    
    public ConnectedComponents(Graph g) {
        visited = new boolean[g.V()];
        id = new int[g.V()];
        count = 0;
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(g, i);
                count++;
            }
        }
    }
    
    public void dfs(Graph g, int start) {
        visited[start] = true;
        id[start] = count;
        for (int neighbor : g.adj(start)) {
            if (!visited[neighbor]) {
                dfs(g, neighbor);
            }
        }
    }
    
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
    
    public int id(int v) {
        return id[v];
    }
    
    public int numberOfConnectedComponents() {
        return count;
    }
}
