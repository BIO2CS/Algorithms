package Graph;

import java.util.*;

public class WeightedEdgeGraph {

    private int V;
    private int E;
    private ArrayList<WeightedEdge>[] adj;
    private double[][] matrix;
    
    public WeightedEdgeGraph(int v) {
        this.V = v;
        this.E = 0;
        adj = (ArrayList<WeightedEdge>[])new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<WeightedEdge>();
        }
        matrix = new double[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i != j) matrix[i][j] = Double.MAX_VALUE;
            }
        }
    }
    
    public int V() {return V;}
    
    public int E() {return E;}
    
    public void addEdge(WeightedEdge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        matrix[v][w] = e.weight();
        matrix[w][v] = e.weight();
        E++;
    }
    
    public Iterable<WeightedEdge> adj(int v) {
        return adj[v];
    }
    
    public double[][] matrix() {
        return matrix;
    }
    
    public Iterable<WeightedEdge> edges() {
        List<WeightedEdge> list = new ArrayList<WeightedEdge>();
        for (int v = 0; v < V; v++) {
            for (WeightedEdge e: adj[v]) {
                if (e.other(v) > v) list.add(e);
            }
        }
        return list;
    }
}
