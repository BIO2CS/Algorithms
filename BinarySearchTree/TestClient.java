package BinarySearchTree;

public class TestClient {

    public static void main(String[] args) {
        //using example on page 263 in CLRS
        BST bst = new BST();
        bst.insert(15);
        bst.insert(5);
        bst.insert(3);
        bst.insert(12);
        bst.insert(10);
        bst.insert(13);
        bst.insert(6);
        bst.insert(7);
        bst.insert(16);
        bst.insert(20);
        bst.insert(18);
        bst.insert(23);
        
       /* TreeTraversal tr = new TreeTraversal();
        tr.inorderTraversal(bst.root);
        tr.inorderWithTreadedTree(bst.root);
        System.out.println("#############################");
        tr.preorderTraversal(bst.root);
        tr.preorderWithThreadedTree(bst.root);
        System.out.println("#############################");       
        tr.postorderTraversal(bst.root);
        tr.postorderWithTreadedTree(bst.root);
        
        //bst.printTree();
        
        TreeNode key = bst.search(15);
        TreeNode next = bst.getPredecessor(key);
        System.out.println(next.key);*/
        
        //using example on Page 303 in CLRS
        AugmentedBST tr = new AugmentedBST();
        int[] nodes = {26, 17, 14, 20, 10, 16, 19, 21, 7, 12, 3, 41, 30, 47, 28, 38, 35, 39};
        for (int d : nodes) {
            tr.insert(d);
        }
        int k = 15;
        AugmentedNode kthNode = tr.selectKthSmallestNode(tr.root, k);
        System.out.println(k + " th smallest node is " + kthNode.val);
    }
}
