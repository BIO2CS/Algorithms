package Graph;

import java.util.*;

public class DepthFirstSearch {

    private boolean[] visited;
    private int count;
    private int[] edgeTo;
    private int start;
    
    public DepthFirstSearch(Graph g, int start) {
        visited = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.start = start;
        dfs(g, start);
    }
    
    public void dfs(Graph g, int s) {
        visited[s] = true;
        count++;
        for (int w : g.adj(s)) {
            if (!visited[w]) {
                edgeTo[w] =  s;
                dfs(g, w);
            }
        }
    }
    
    public boolean visited(int v) {
        return visited[v];
    }
    
    public int count() {
        return count;
    }
    
    public boolean hasPathTo(int v) {
        return visited[v];
    }
    
    public Iterable<Integer> pathTo(int v) {
        List<Integer> path = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int x = v; x != start; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(start);
        while(!stack.isEmpty()) {
            path.add(stack.pop());
        }
        return path;
    }
}
