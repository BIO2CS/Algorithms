package Graph;

import java.util.*;
import UnionFind.QuickFindUF;

public class KruskalMST {

    private Queue<WeightedEdge> mst;
    private Queue<WeightedEdge> queue;
    private QuickFindUF uf;
    
    public KruskalMST(WeightedEdgeGraph g) {
        int numberOfEdges = g.E();
        int numberOfVertices = g.V();
        mst = new LinkedList<WeightedEdge>();
        queue = new PriorityQueue<WeightedEdge>(numberOfEdges, new Comparator<WeightedEdge>(){
            public int compare(WeightedEdge e1, WeightedEdge e2) {
                if (e1.weight() < e2.weight()) return -1;
                if (e1.weight() > e2.weight()) return 1;
                return 0;
            }            
        });
        for (WeightedEdge e : g.edges()) {
            queue.offer(e);
        }
        uf = new QuickFindUF(numberOfVertices);
      
        mst(g);
    }
    
    public void mst(WeightedEdgeGraph g) {
        while (!queue.isEmpty() && mst.size() < g.V() - 1) {
            WeightedEdge front = queue.poll();
            int v = front.either();
            int w = front.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.offer(front);
        }
    }
    
    public Iterable<WeightedEdge> edges() {
        return mst;
    }
    
    public void printMST() {
        double totalWeight = 0;
        while (!mst.isEmpty()) {
            totalWeight += mst.peek().weight();
            System.out.println(mst.poll().toString());
        }
        System.out.println("Total weight of MST is " + totalWeight);
    }
}
