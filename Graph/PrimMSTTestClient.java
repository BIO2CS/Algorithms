package Graph;

import java.util.*;

public class PrimMSTTestClient {

    public static void main(String[] args) {
        int v = 9;
        WeightedEdgeGraph g = new WeightedEdgeGraph(v);
        WeightedEdge[] edges = {new WeightedEdge(0, 1, 4),new WeightedEdge(0, 7, 8),new WeightedEdge(1, 2, 8),
                new WeightedEdge(1, 7, 11),new WeightedEdge(2, 3, 7),new WeightedEdge(2, 8, 2),
                new WeightedEdge(2, 5, 4),new WeightedEdge(3, 4, 9), new WeightedEdge(3, 5, 14),
                new WeightedEdge(4, 5, 10),new WeightedEdge(5, 6, 2),new WeightedEdge(6, 7, 1),
                new WeightedEdge(6, 8, 6),new WeightedEdge(7, 8, 7)};
        
        for (WeightedEdge e : edges) {
            g.addEdge(e);
        }
        
     /*   PrimMSTUsingMatrix mst = new PrimMSTUsingMatrix(g);
        mst.printMST();*/
        
        PrimMSTUsingAdj mst = new PrimMSTUsingAdj(g);
        mst.printMST();
    }
}
