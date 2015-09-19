package Graph;

import java.util.*;

public class Graph {
    @SuppressWarnings("unchecked")
    public Graph(int v) {
        numberOfVertices = v;
        numberOfEdges = 0;
        adj = (ArrayList<Integer>[])new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        numberOfEdges++;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
    public int V() {return numberOfVertices;}
    
    public int E() {return numberOfEdges;}
    
    public void printGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adj[i]) {
                System.out.print(neighbor + ", ");
            }
            System.out.println();
        }
    }
    
    private int numberOfVertices;
    private int numberOfEdges;
    private ArrayList<Integer>[] adj;
}

/*class Node {
    public Node(int k, int v) {
        key = k;
        value = v;
        next = null;
    }    
    int key;
    int value;
    Node next;    
}*/