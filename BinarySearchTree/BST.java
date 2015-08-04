package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST {
    TreeNode root;
    
    public BST() {        
    }
    
    public void insert(int key) {
        TreeNode node = new TreeNode(key);
        TreeNode pre = null, runner = root;
        while (runner != null) {
            pre = runner;
            if (runner.key == key) {
                return;
            }
            if (key < runner.key) {
                runner = runner.left;
            }
            else {
                runner = runner.right;
            }
        }
        node.parent = pre;
        if (pre == null) {
            root = node;
        }        
        else if (pre.key < key){
            pre.right = node;
        }
        else {
            pre.left = node;
        }
    }
    
    public TreeNode search(int key) {
        TreeNode runner = root;
        while (runner != null) {
            if (key == runner.key) {
                return runner;
            }
            if (key < runner.key) {
                runner = runner.left;
            }
            else {
                runner = runner.right;
            }
        }
        return null;
    }
    
    public TreeNode getMinNode(TreeNode x) {
        if (x == null) {
            return null;
        }
        TreeNode runner = x;
        while (runner.left != null) {
            runner = runner.left;
        }
        return runner;
    }
    
    public TreeNode getMaxNode(TreeNode x) {
        if (x == null) {        
            return null;
        }
        TreeNode runner = x;
        while (runner.right != null) {
            runner = runner.right;
        }
        return runner;
    }
    
    public TreeNode getSuccessor(TreeNode x) {
        if (x == null) return null;
        if (x.right != null) {
            return getMinNode(x.right);
        }
        TreeNode p = x.parent;
        while (p != null && x == p.right) {
            x = p;
            p = p.parent;
        }
        return p;
    }
    
    public TreeNode getPredecessor(TreeNode x) {
        if (x == null) return null;
        if (x.left != null) { 
            return getMaxNode(x.left);
        }
        TreeNode p = x.parent;
        while (p != null && x == p.left) {
            x = p;
            p = p.parent;
        }
        return p;
    }
    
    public void delete(TreeNode x) {
        if (x == null) return;
        TreeNode splicedNode = null;
        //case 1: x is leaf node;
        if (x.left == null && x.right == null) {
            splicedNode = x;
        }
        //case 2: x has only one child;
        else if (x.left == null || x.right == null) {
            splicedNode = x;
        }
        //case 3: x has two children;
        else {
            splicedNode = getSuccessor(x);
        }
        TreeNode childOfSplicedNode = null;
        if (splicedNode.left != null) {
            childOfSplicedNode = splicedNode.left;
        }
        else {
            childOfSplicedNode = splicedNode.right;
        }
        if (childOfSplicedNode != null) {
            childOfSplicedNode.parent = splicedNode.parent;
        }
        if (splicedNode.parent == null) {
            root = childOfSplicedNode;
        }
        else {
            if (splicedNode == splicedNode.parent.left) {
                splicedNode.parent.left = childOfSplicedNode;
            }
            else {
                splicedNode.parent.right = childOfSplicedNode;
            }
        }
        if (splicedNode != x) {
            x.key = splicedNode.key;
        }
    }
    
    public void printTree() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int parent = 1, children = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            list.add(front.key);
            if (front.left != null) {
                queue.offer(front.left);
                children++;
            }
            if (front.right != null) {
                queue.offer(front.right);
                children++;
            }
            if (--parent == 0) {
                for (Integer d : list) {
                    System.out.print(d + " ");
                }
                System.out.println();
                list = new ArrayList<Integer>();
                parent = children;
                children = 0;
            }
        }
    }
    
    private void printUtil(List<Integer> list, String traversalType) {
        System.out.println("Binary Search Tree Iterative " + traversalType + " Traversal");
        for (int d : list) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
    
    public void inorderTraversal() {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode runner = root;
        while (runner != null || !stack.isEmpty()) {
            if (runner != null) {
                stack.push(runner);
                runner = runner.left;
            }
            else {
                TreeNode top = stack.pop();
                list.add(top.key);
                runner = top.right;
            }
        }
        printUtil(list, "Inorder");
    }
    
    public void preorderTraversal() {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode runner = root;
        while (runner != null || !stack.isEmpty()) {
            if (runner != null) {
                list.add(runner.key);
                if (runner.right != null) {
                    stack.add(runner.right);
                }
                runner = runner.left;
            }
            else {
                runner = stack.pop();
            }            
        }
        printUtil(list, "Preorder");
    }
    
    public void postorderTraversal() {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode runner = root, pre = null;
        while (runner != null || !stack.isEmpty()) {
            if (runner != null) {
                stack.push(runner);
                runner = runner.left;
            }
            else {
                TreeNode top = stack.peek();
                if (top.right == null || top.right == pre) {
                    list.add(top.key);
                    pre = stack.pop();
                }
                else {
                    runner = top.right;
                }
            }
        }
        printUtil(list, "Postorder");
    }
}
