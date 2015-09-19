package Graph;

import java.util.*;

public class DirectedDFS {

    private boolean[] visited;
    private int[] pathTo;
    private int start;
    
    public DirectedDFS(DirectedGraph g, int s) {
        start = s;
        visited = new boolean[g.V()];
        pathTo = new int[g.V()];
        dfs(g, s);
        pathTo[s] = s;
    }
    
    public void dfs(DirectedGraph g, int v) {
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                pathTo[w] = v;
                dfs(g, w);
            }
        }
    }
    
    public boolean hasPathTo(int v) {
        return visited[v];
    }
    
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != start; x = pathTo[x]) {
            stack.push(x);
        }
        stack.push(start);
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
