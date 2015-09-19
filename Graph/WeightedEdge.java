package Graph;

public class WeightedEdge implements Comparable<WeightedEdge>{

    private int v;
    private int w;
    private double weight;
    
    public WeightedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    public int either() {
        return v;
    }
    
    public int other(int x) {
        if (x == v) return w;
        if (x == w) return v;
        throw new IllegalArgumentException("Input of edge index is not found");
    };
    
    public double weight() {
        return weight;
    }
    
    public int compareTo(WeightedEdge that) {
        if (this.weight() < that.weight()) return -1;
        if (this.weight() > that.weight()) return 1;
        return 0;
    }
    
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
 