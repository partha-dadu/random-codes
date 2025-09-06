package com.partha.random.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostAndInOrder {


    public static void main(String[] args) {
        ConstructTreeFromPostAndInOrder obj = new ConstructTreeFromPostAndInOrder();
        int[] postOrder = {4,2,6,5,3,1};
        int[] inOrder = {4,2,1,5,6,3};
        LeetCodeTreeNode root = obj.constructTreeFromPostAndInOrd(postOrder, inOrder);
    }


    public LeetCodeTreeNode constructTreeFromPostAndInOrd(int[] postOrder, int[] inorder) {
        if(postOrder == null || inorder == null || postOrder.length == 0 || inorder.length == 0){
            return null;
        }
        if(postOrder.length != inorder.length){
            throw new IllegalArgumentException();
        }
        if(postOrder.length == 1){
            return new LeetCodeTreeNode(postOrder[0]);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        LeetCodeTreeNode root = recursiveBuildPostAndInOrder(postOrder, 0, postOrder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public LeetCodeTreeNode recursiveBuildPostAndInOrder(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> hashedIn){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        LeetCodeTreeNode node = new LeetCodeTreeNode(postOrder[postEnd]);
        int hashedRootIn = hashedIn.get(postOrder[postEnd]);
        int leftSubTreeLength = hashedRootIn - inStart;

        node.left = recursiveBuildPostAndInOrder(postOrder, postStart, postStart+ leftSubTreeLength-1, inOrder, inStart, hashedRootIn-1, hashedIn );
        node.right = recursiveBuildPostAndInOrder(postOrder, postStart+leftSubTreeLength, postEnd-1, inOrder, hashedRootIn+1, inEnd, hashedIn);
        return node;
    }
}
