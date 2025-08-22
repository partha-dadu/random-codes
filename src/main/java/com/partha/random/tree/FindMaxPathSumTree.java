package com.partha.random.tree;

public class FindMaxPathSumTree {

    public static void main(String[] args) {
        FindMaxPathSumTree findMaxPathSumTree = new FindMaxPathSumTree();
        TreeNode root = findMaxPathSumTree.buildTree();
        int[] maxSum = new int[1];
        findMaxPathSumTree.findMaxPathSum(root, maxSum);
        System.out.println("Max Path Sum -> "+ maxSum[0]);
    }

    public int findMaxPathSum(TreeNode node, int[] maxPathSum) {
        if(node==null){
            return 0;
        }
        int left = Math.max(0, findMaxPathSum(node.getLeft(), maxPathSum));
        int right = Math.max(0, findMaxPathSum(node.getRight(), maxPathSum));
        maxPathSum[0]=Math.max(maxPathSum[0], node.getData() + left + right);
        return node.getData() + Math.max(left, right);
    }

    public TreeNode buildTree(){
        TreeNode root = new TreeNode(7);
        root.setLeft(new TreeNode(8));
        root.setRight(new TreeNode(-2));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(12));
        return root;
    }
}
