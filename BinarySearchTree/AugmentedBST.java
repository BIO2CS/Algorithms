package BinarySearchTree;

public class AugmentedBST {

    AugmentedNode root;
    
    public AugmentedBST() {
        
    }
    
    public void insert(int v) {
        AugmentedNode x = new AugmentedNode(v);
        if (root == null) {
            root = x;
        }
        else {
            AugmentedNode runner = root, pre = null;
            while (runner != null) {
                if (runner.val == x.val) return;
                runner.rank++;
                pre = runner;
                if (x.val < runner.val) {                    
                    runner = runner.left;
                }
                else {
                    runner = runner.right;                    
                }
            }
            if (pre.val > x.val) {
                pre.left = x;
            }
            else {
                pre.right = x;
            }
            x.parent = pre;
        }
    }
    
    public AugmentedNode selectKthSmallestNode(AugmentedNode root, int k) {
        int leftSize = root.left == null ? 0 : root.left.rank;
        leftSize++;
        if (leftSize == k) return root;
        if (k < leftSize) return selectKthSmallestNode(root.left, k);
        return selectKthSmallestNode(root.right, k - leftSize);
    }
    
    public int getRank(AugmentedNode root, AugmentedNode x) {
        int total = root.left == null ? 1 : root.left.rank + 1;
        AugmentedNode runner = x;
        while (runner != root) {
            if (runner == runner.parent.right) {
                total += runner.parent.left == null ? 1 : runner.parent.left.rank + 1;
            }
            runner = runner.parent;
        }
        return total;
    }
   
}

class AugmentedNode {
    int val;
    int rank;
    AugmentedNode left, right, parent;
    AugmentedNode(int x) {
        val = x;
        rank = 1;
    }
}
