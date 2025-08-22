package com.partha.random.tree;

public class FindHeightOfTree {

    public static void main(String[] args) {
        FindHeightOfTree obj = new FindHeightOfTree();
        TreeNode root = obj.buildHeightTree();
        int height = obj.findHeight(root);
        System.out.println(height);
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findHeight(root.getLeft());
        int rightHeight = findHeight(root.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode buildHeightTree() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().getRight().setRight(new TreeNode(8));
        root.getRight().getRight().getRight().setLeft(new TreeNode(9));
        return  root;
    }
}
