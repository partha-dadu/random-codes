package com.partha.random.tree.traversal;

import com.partha.random.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBFSTraversal {

    public static void main(String[] args) {
        LevelOrderBFSTraversal bfsTraversal = new LevelOrderBFSTraversal();
        TreeNode root = buildTree();
        System.out.println(bfsTraversal.levelOrderBFS(root));
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root){
        if(root == null){
            return  new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelOrderTraversal = new ArrayList<List<Integer>>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> levelData = new ArrayList<>();
            for(int i = 0; i < currentLevelSize; i++){
                TreeNode currentNode = queue.peek();
                if(currentNode.getLeft() != null){
                    queue.offer(currentNode.getLeft());
                }
                if(currentNode.getRight() != null){
                    queue.offer(currentNode.getRight());
                }
                levelData.add(currentNode.getData());
                queue.poll();
            }
            levelOrderTraversal.add(levelData);

        }
        return  levelOrderTraversal;
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
