package com.partha.random.tree.bst;

import com.partha.random.tree.TreeNode;

public class ValidateBSTProperty {

    public static void main(String[] args) {
        ValidateBSTProperty validateBSTProperty = new ValidateBSTProperty();
        boolean result = validateBSTProperty.validateBST(buildTree());
        System.out.println(result);
    }

    public boolean validateBST(TreeNode root){
        if(root == null){
            return true;
        }
        return checkBSTwithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBSTwithRange(TreeNode node, int low, int high){
        if(node == null){
            return true;
        }
        if(node.getData() < low || node.getData() > high){
            return false;
        }
        return checkBSTwithRange(node.getLeft(), low, node.getData()) && checkBSTwithRange(node.getRight(), node.getData(), high);
    }

    public static TreeNode buildTree(){
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(6));
        root.setRight(new TreeNode(9));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().getLeft().setLeft(new TreeNode(1));
        root.getLeft().getLeft().getLeft().setRight(new TreeNode(2));
        root.getRight().setLeft(new TreeNode(8));
        root.getRight().setRight(new TreeNode(10));
        return root;
    }

}
