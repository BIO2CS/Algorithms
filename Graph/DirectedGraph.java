package Graph;

import java.util.*;

public class DirectedGraph {

    private int edges;
    private int vertices;
    private ArrayList<Integer>[] adj;
    
    @SuppressWarnings("unchecked")
    public DirectedGraph(int v) {
        edges = 0;
        vertices = v;
        adj = (ArrayList<Integer>[])new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        edges++;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
    public int V() {
        return vertices;
    }
    
    public int E() {
        return edges;
    }
}
