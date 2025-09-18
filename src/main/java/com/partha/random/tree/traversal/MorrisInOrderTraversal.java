package com.partha.random.tree.traversal;

import com.partha.random.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {

    public static void main(String[] args) {
        MorrisInOrderTraversal morris = new MorrisInOrderTraversal();
        List<TreeNode> res = morris.traverseInOrderMorris(buildTree2());
        res.forEach(n -> System.out.println(n.getData()));
    }

    public List<TreeNode> traverseInOrderMorris(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        TreeNode curr = root;

        if(root.getLeft() == null && root.getRight() == null){
            res.add(root);
            return res;
        }

        while(curr != null){
            if(curr.getLeft() == null){
                res.add(curr);
                curr = curr.getRight();
            }
            else {
                TreeNode prev = curr.getLeft();
                while(prev.getRight() != null && prev.getRight() != curr){
                    prev = prev.getRight();
                }
                if(prev.getRight() == null){
                    prev.setRight(curr);
                    curr = curr.getLeft();
                }else {
                    res.add(curr);
                    prev.setRight(null);
                    curr = curr.getRight();
                }
            }
        }
        return res;
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
