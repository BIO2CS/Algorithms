package BinarySearchTree;

public class TestClient {

    public static void main(String[] args) {
        //using example on page 263 in CLRS
        BST bst = new BST();
        bst.Insert(15);
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(12);
        bst.Insert(10);
        bst.Insert(13);
        bst.Insert(6);
        bst.Insert(7);
        bst.Insert(16);
        bst.Insert(20);
        bst.Insert(18);
        bst.Insert(23);
     //   bst.printTree();
        
        TreeNode key = bst.search(15);
        TreeNode next = bst.getPredecessor(key);
        System.out.println(next.key);
    }
}
