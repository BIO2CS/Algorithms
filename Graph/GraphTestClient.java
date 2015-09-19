package Graph;

import java.util.*;

public class GraphTestClient {

    public static void main(String[] args) {
        /*Graph g = new Graph(13);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        
        g.addEdge(7, 8);
        
        g.addEdge(9, 10);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
       
        g.addEdge(11, 12);*/
        
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        
        g.printGraph();
        
        int s = 0;
//        DepthFirstSearch search = new DepthFirstSearch(g, 0);
       /* BreadthFirstSearch search = new BreadthFirstSearch(g, 0);
        for (int i = 0; i < g.V(); i++) {
            if (search.hasPathTo(i)) {
                System.out.print(s + " to " + i + ": ");
                for (int x : search.pathTo(i)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("->" + x);
                }
                System.out.println();
            }
        }*/
        
       /* ConnectedComponents cc = new ConnectedComponents(g);
        int counts = cc.numberOfConnectedComponents();
        System.out.println("Number of Components " + counts);
        List<List<Integer>> components = new ArrayList<List<Integer>>();
        for (int i = 0; i < counts; i++) {
            List<Integer> list = new ArrayList<Integer>();
            System.out.print("Component " + i + ": ");
            for (int v = 0; v < g.V(); v++) {
                if (cc.id(v) == i) {
                    list.add(v);
                    System.out.print(v + ", ");
                }
            }
            System.out.println();
        }        */
        
        Cycle c = new Cycle(g);
        System.out.println(c.hasCycle());
    }
    
}
