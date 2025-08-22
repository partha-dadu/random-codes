package com.partha.random.tree;

import java.util.ArrayList;
import java.util.List;

public class FindRootToNodePath {

    public static void main(String[] args) {
        FindRootToNodePath findRootToNodePath = new FindRootToNodePath();
        findRootToNodePath.findRootToNodePath(findRootToNodePath.buildTree(), new ArrayList<>(),7);
        findRootToNodePath.rootToNodePathCaller(findRootToNodePath.buildTree(), 7);
    }

    public List<Integer> findRootToNodePath(TreeNode root, List<Integer> path, int target){
        if(root == null){
            return path;
        }

        path.add(root.getData());
        if(path.get(path.size()-1) == target){
            System.out.println(path);
        }
        if(root.getLeft() != null) {
            findRootToNodePath(root.getLeft(), path, target);
            path.remove(path.size() - 1);
        }
        if(root.getRight() != null) {
            findRootToNodePath(root.getRight(), path, target);
            path.remove(path.size() - 1);
        }

        return path;
    }

    public List<Integer> rootToNodePathCaller(TreeNode root, int target){
        List<Integer> path = new ArrayList<>();
        getRootToNodePath(root, path, target);
        System.out.println(path);
        return path;
    }

    public boolean getRootToNodePath(TreeNode root, List<Integer> path, int target){
        if(root == null){
            return false;
        }
        path.add(root.getData());
        if(root.getData() == target){
            return true;
        }
        if(getRootToNodePath(root.getLeft(), path, target) || getRootToNodePath(root.getRight(), path, target)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getLeft().getLeft().setRight(new TreeNode(8));
        root.getRight().getRight().setLeft(new TreeNode(9));
        return root;
    }
}
