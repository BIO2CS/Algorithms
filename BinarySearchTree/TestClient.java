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
        
        bst.inorderTraversal();
        bst.preorderTraversal();
        bst.postorderTraversal();
        
        //bst.printTree();
        
        TreeNode key = bst.search(15);
        TreeNode next = bst.getPredecessor(key);
        System.out.println(next.key);
    }
}
