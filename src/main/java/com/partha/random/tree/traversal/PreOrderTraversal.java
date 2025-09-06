package com.partha.random.tree.traversal;

import com.partha.random.tree.TreeNode;

public class PreOrderTraversal {

    /**
     * Pre-Order traversal means Root-Left-Right of a particular Tree/SubTree
     *
     * **/

    public static void main(String[] args) {
        TreeNode root = buildTree2();
        PreOrderTraversal traversal = new PreOrderTraversal();
        traversal.printPreOrder(root);

    }

    public void printPreOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.getData());
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
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

    static TreeNode buildTree2() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(5));
        root.getRight().getLeft().setRight(new TreeNode(6));
        return  root;
    }
}
