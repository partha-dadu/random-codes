package com.partha.random.tree;

public class FindBalancedTree {

    public static void main(String[] args) {
        FindBalancedTree bft = new FindBalancedTree();
        System.out.println(bft.checkBalance(bft.buildUnBalancedTree()));
        System.out.println("checkBalanceTree -> "+ (bft.checkBalanceTree(bft.buildUnBalancedTree()) != -1));
    }

    public int checkBalanceTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = checkBalanceTree(node.getLeft());
        if (lh == -1) {
            return -1;
        }
        int rh = checkBalanceTree(node.getRight());
        if (rh == -1) {
            return -1;
        }
        if(Math.abs(lh - rh) > 1){
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }

    public boolean checkBalance(TreeNode node) { // O (N^2)
        if (node == null) {
            return true;
        }
        int leftHeight = findHeight(node.getLeft());
        int rightHeight = findHeight(node.getRight());
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        boolean left = checkBalance(node.getLeft());
        boolean right = checkBalance(node.getRight());
        if(!left || !right) {
            return false;
        }
        return true;
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findHeight(root.getLeft());
        int right = findHeight(root.getRight());

        return Math.max(left, right) + 1;
    }

    public TreeNode buildUnBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().getLeft().setLeft(new TreeNode(5));
        root.getLeft().setLeft(new TreeNode(6));
        return root;
    }
}
