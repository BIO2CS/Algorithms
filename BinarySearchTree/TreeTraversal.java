package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    private void printUtil(List<Integer> list, String traversalType) {
        System.out.println("Binary Search Tree Iterative " + traversalType + " Traversal");
        for (int d : list) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
    
    public void inorderTraversal(TreeNode root) {
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
    
    public void preorderTraversal(TreeNode root) {
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
    
    public void postorderTraversal(TreeNode root) {
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
    
    /**
     * Traversal using treaded tree: non-recursive, no-stack 
     */
    
    public void inorderWithTreadedTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode runner = root;
        while (runner != null) {
            if (runner.left == null) {
                list.add(runner.key);
                runner = runner.right;
            }
            else {
                TreeNode pre = runner.left;
                while (pre.right != null && pre.right != runner) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = runner;
                    runner = runner.left;
                }
                else {
                    list.add(runner.key);
                    runner = runner.right;
                    pre.right = null;                    
                }
            }
        }
        printUtil(list, "Inorder Morris Traversal Using Treaded Tree");
    }
    
    public void preorderWithThreadedTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode runner = root;
        while (runner != null) {
            if (runner.left == null) {
                list.add(runner.key);
                runner = runner.right;
            }
            else {
                TreeNode pre = runner.left;
                while (pre.right != null && pre.right != runner) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    list.add(runner.key);
                    pre.right = runner;
                    runner = runner.left;
                }
                else {
                    pre.right = null;
                    runner = runner.right;
                }
            }
        }
        printUtil(list, "Preorder Morris Traversal Using Treaded Tree");
    }
    
    public void postorderWithTreadedTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode runner = dummy;
        while (runner != null) {
            if (runner.left == null) {
                runner = runner.right;
            }
            else {
                TreeNode pre = runner.left;
                while (pre.right != null && pre.right != runner) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = runner;
                    runner = runner.left;
                }
                else {
                    List<Integer> subList = new ArrayList<Integer>();
                    TreeNode temp = runner.left;
                    while (temp != pre) {
                        subList.add(temp.key);
                        temp = temp.right;
                    }
                    subList.add(temp.key);                 
                    Collections.reverse(subList);
                    list.addAll(subList);
                    pre.right = null;
                    runner = runner.right;
                }
            }
        }
        dummy.left = null;
        printUtil(list, "Postorder Morris Traversal Using Treaded Tree");
    }
}
