package com.partha.random.tree.traversal;

import com.partha.random.tree.TreeNode;

public class InOrderTraversal {

    public static void main(String[] args) {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        TreeNode root = buildTree();
        inOrderTraversal.printInOrder(root);
    }

    public void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.getLeft());
        System.out.println(root.getData());
        printInOrder(root.getRight());
    }

    static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getLeft().getRight().setLeft(new TreeNode(6));
        root.getRight().setLeft(new TreeNode(7));
        root.getRight().setRight(new TreeNode(8));
        root.getRight().getRight().setLeft(new TreeNode(9));
        root.getRight().getRight().setRight(new TreeNode(10));

        return  root;
    }
}
