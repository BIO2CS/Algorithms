package Graph;

import java.util.*;

public class DirectedBFS {

    private boolean[] visited;
    private int[] pathTo;
    private int[] distTo;
 //   private int start; 
    
    public DirectedBFS(DirectedGraph g, int s) {
    //    start = s;
        visited = new boolean[g.V()];
        pathTo = new int[g.V()];
        distTo = new int[g.V()];
        pathTo[s] = s;
        bfs(g, s);
    }
    
    public void bfs(DirectedGraph g, int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        distTo[s] = 0;
        queue.offer(s);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : g.adj(v)) {
                if (!visited[w]){
                    visited[w] = true;
                    distTo[w] = distTo[v] + 1;
                    pathTo[w] = v;
                    queue.offer(w);
                }
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
        int x = v;
        for (; distTo[x] != 0; x = pathTo[x]) {
            stack.push(x);
        }
        stack.push(x);
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
