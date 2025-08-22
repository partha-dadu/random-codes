package com.partha.random.tree;

public class FindDiameterOfTree {

    public static void main(String[] args) {
        FindDiameterOfTree f = new FindDiameterOfTree();
        TreeNode root = f.buildTree();
        int[] pointer = new int[1];
        f.findDiameterOfTree((root), pointer);
        System.out.println("Diameter of tree -> "+ pointer[0]);
    }

    public int findDiameterOfTree(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findDiameterOfTree(node.getLeft(), maxDiameter);
        int rightHeight = findDiameterOfTree(node.getRight(), maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight+1);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().getLeft().setLeft(new TreeNode(6));
        root.getRight().getLeft().getLeft().setLeft(new TreeNode(10));
        root.getRight().setRight(new TreeNode(5));
        root.getRight().getRight().setLeft(new TreeNode(7));
        root.getRight().getRight().getLeft().setRight(new TreeNode(8));
        root.getRight().getRight().getLeft().getRight().setLeft(new TreeNode(9));
        return root;
    }
}
