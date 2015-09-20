package UnionFind;

public class QuickFindUF {

    private int[] id;
    private int count;
    
    public QuickFindUF(int n) {
        id = new int[n];
        count = n;
        
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    
    public int find(int p) {
        validate(p);
        return id[p];        
    }
    
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }
    
    public void union(int p, int q) {
        int pID = id[p], qID = id[q];
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
    
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("element " + p + " is out of range");
        }
    }
}
