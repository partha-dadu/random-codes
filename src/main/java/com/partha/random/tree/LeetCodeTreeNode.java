package com.partha.random.tree;

public class LeetCodeTreeNode {

        int val;
    LeetCodeTreeNode left;
    LeetCodeTreeNode right;
    LeetCodeTreeNode() {}
    LeetCodeTreeNode(int val) { this.val = val; }
    LeetCodeTreeNode(int val, LeetCodeTreeNode left, LeetCodeTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}
