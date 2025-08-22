package com.partha.random.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindBoundaryTraversalOfTree {

    public static void main(String[] args) {
        FindBoundaryTraversalOfTree ft = new FindBoundaryTraversalOfTree();
        TreeNode root = ft.buildSkewedTree();
        List<Integer> result = new ArrayList<>();
        ft.findBoundaryOfTree(root, result);

    }

    public List<Integer> findBoundaryOfTree(TreeNode node, List<Integer> boundaryNodesOrder) {

        if(!isLeafNode(node)){
            boundaryNodesOrder.add(node.getData());
        }
        findLeftBoundary(node.getLeft(), boundaryNodesOrder);
        addLeaves(node, boundaryNodesOrder);
        findRightBoundary(node.getRight(), boundaryNodesOrder);
        System.out.println("BOundaryTraversal -> "+boundaryNodesOrder);
        return boundaryNodesOrder;
    }

    public void addLeaves(TreeNode node, List<Integer> boundaryNodesOrder) {
        if(isLeafNode(node)){
            boundaryNodesOrder.add(node.getData());
            return ;
        }
        if(node.getLeft() != null ) addLeaves(node.getLeft(), boundaryNodesOrder);
        if(node.getRight() != null) addLeaves(node.getRight(), boundaryNodesOrder);
    }

    public void findLeftBoundary(TreeNode node, List<Integer> boundaryNodesOrder) {
        TreeNode current = node;
        while(current!=null){
            if(!isLeafNode(current)){
                boundaryNodesOrder.add(current.getData());
            }
            if(current.getLeft() != null) current = current.getLeft();
            else current = current.getRight();
        }
    }

    public void findRightBoundary(TreeNode node, List<Integer> boundaryNodesOrder) {
        TreeNode current = node;
        List<Integer> stack = new Stack<>();

        while(current!=null){
            if(!isLeafNode(current)){
                stack.add(current.getData());
            }
            if(current.getRight() != null) current = current.getRight();
            else current = current.getLeft();
        }
        while(!stack.isEmpty()){
            boundaryNodesOrder.add(stack.remove(0));
        }
    }

    public boolean isLeafNode(TreeNode node) {
        if(node != null && node.getLeft() == null && node.getRight() == null){
            return true;
        }
        return false;
    }

    public TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.getLeft().setLeft((new TreeNode(3)));
        root.getLeft().getLeft().setRight(new TreeNode(4));
        root.getLeft().getLeft().getRight().setLeft(new TreeNode(5));
        root.getLeft().getLeft().getRight().setRight(new TreeNode(6));
        root.setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(25));
        root.getRight().getLeft().setLeft(new TreeNode(31));
        root.getRight().setRight(new TreeNode(8));
        root.getRight().getRight().setLeft(new TreeNode(9));
        root.getRight().getRight().getLeft().setLeft(new TreeNode(10));
        root.getRight().getRight().getLeft().setRight(new TreeNode(11));
        return root;
    }

    public TreeNode buildSkewedTree(){
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().getLeft().setLeft(new TreeNode(4));
        return root;
    }
}
