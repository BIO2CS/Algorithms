package Graph;

import java.util.*;

public class BreadthFirstSearch {

    private boolean[] visited;
    private int[] edgeTo;
    private int start;
    
    public BreadthFirstSearch(Graph g, int start) {
        this.start = start;
        visited = new boolean[g.V()];
        edgeTo = new int[g.V()];
        bfs(g, start);
    }
    
    public void bfs(Graph g, int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int front = queue.poll();
            for (int neighbor : g.adj(front)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    edgeTo[neighbor] = front;
                    queue.offer(neighbor);
                }
            }
        }
    }
    
    public boolean hasPathTo(int v) {return visited[v];}
    
    public Iterable<Integer> pathTo(int v) {
        List<Integer> path = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != start; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(start);
        while(!stack.isEmpty()) {
            path.add(stack.pop());
        }
        return path;
    }
}
