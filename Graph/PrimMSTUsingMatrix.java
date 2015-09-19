package Graph;

public class PrimMSTUsingMatrix {

    private boolean[] visited;
    private double[] distTo;
    private int[] pathTo;
    private int numberOfVerticesInMST;
    
    public PrimMSTUsingMatrix(WeightedEdgeGraph g) {
        numberOfVerticesInMST = g.V() - 1;
        visited = new boolean[g.V()];
        distTo = new double[g.V()];
        pathTo = new int[g.V()];
        
        for (int v = 0; v < g.V(); v++) {
            distTo[v] = Double.MAX_VALUE;
        }
        distTo[0] = 0.0;
        mstUsingMatrix(g);
    }
    
    public void mstUsingMatrix(WeightedEdgeGraph g) {
        for (int count = 0; count < numberOfVerticesInMST; count++) {
            int v = getMinWeightIndex(g.V());
            visited[v] = true;
            for (int w = 0; w < g.V(); w++) {
                if (!visited[w] && g.matrix()[v][w] < distTo[w]) {
                    pathTo[w] = v;
                    distTo[w] = g.matrix()[v][w];
                }
            }
        }
    }

    public void printMST() {
        double totalWeight = 0;
        for (int v = 1; v <= numberOfVerticesInMST; v++) {
            totalWeight += distTo[v];
            System.out.format("%d - %d: %.0f%n", pathTo[v], v, distTo[v]);
        }
        System.out.format("Total Weight in MST is: %.0f%n", totalWeight);
    }
    
    private int getMinWeightIndex(int n) {
        int index = -1;
        double minWeight = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && distTo[i] < minWeight) {
                index = i;
                minWeight = distTo[i];
            }
        }
        return index;
    }
}
