package Graph;

import java.util.*;

public class TopologicalSorting {

    private boolean[] visited;
    private boolean[] onStack;
    private int[] pathTo;
    
    private boolean hasCycle = false;
    private Stack<Integer> cycle;
    
    private Stack<Integer> postOrder;
    
    public TopologicalSorting(DirectedGraph g) {
        visited = new boolean[g.V()];
        onStack = new boolean[g.V()];
        pathTo = new int[g.V()];
        postOrder = new Stack<Integer>();
        
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(g, i);
            }
        }
    }
    
    public void dfs(DirectedGraph g, int v) {
        visited[v] = true;
        onStack[v] = true;
        for (int w : g.adj(v)) {
            if (hasCycle) return;
            if (!visited[w]) {
                pathTo[w] = v;
                dfs(g,  w);
            }
            else if (onStack[w]) {
                hasCycle = true;
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int x = v; x != w; x = pathTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
        onStack[v] = false;
        postOrder.push(v);
    }
    
    public Iterable<Integer> topoOrder() {
        if (hasCycle) return null;
        List<Integer> list = new ArrayList<Integer>();
        while (!postOrder.isEmpty()) {
            list.add(postOrder.pop());
        }
        return list;
    }
    
    public boolean hasCycle() {
        return hasCycle;
    }
}
