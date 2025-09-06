package com.partha.random.tree;

import com.partha.random.tree.traversal.PreOrderTraversal;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreAndInOrder {
    public static void main(String[] args) {
        ConstructTreeFromPreAndInOrder obj = new ConstructTreeFromPreAndInOrder();
        int[] inorder = {4,2,1,5,6,3};
        int[] preOrder = {1,2,4,3,5,6};
        LeetCodeTreeNode root = obj.constructTreeFromPreAndInOrder(preOrder, inorder);
        PreOrderTraversal traversal = new PreOrderTraversal();
        //traversal.printPreOrder(root);
    }

    public LeetCodeTreeNode constructTreeFromPreAndInOrder(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        if(preorder.length != inorder.length){
            throw new IllegalArgumentException();
        }
        if(preorder.length == 1){
            return new LeetCodeTreeNode(preorder[0]);
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        LeetCodeTreeNode root = recursiveBuildTreePreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public LeetCodeTreeNode recursiveBuildTreePreIn(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> hashedIn){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        LeetCodeTreeNode node = new LeetCodeTreeNode(preOrder[preStart]);
        int hashedRootIndex = hashedIn.get(preOrder[preStart]);
        int leftSubTreeLength = hashedRootIndex - inStart;

        node.left = recursiveBuildTreePreIn(preOrder, preStart+1, preStart+leftSubTreeLength, inOrder, inStart, hashedRootIndex-1, hashedIn);
        node.right = recursiveBuildTreePreIn(preOrder, preStart+leftSubTreeLength+1, preEnd, inOrder, hashedRootIndex+1, inEnd, hashedIn);
        return node;
    }

}
