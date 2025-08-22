package com.partha.random.tree;

public class FindLCAtwoNodes {

    public static void main(String[] args) {
        FindLCAtwoNodes f = new FindLCAtwoNodes();
        int result = f.findLCAtwoNodes(f.buildTree(),4,2);
        System.out.println(result);
        TreeNode resultOptimal = f.findLCAtwoNodesOptimal(f.buildTree(),6,7);
        System.out.println(resultOptimal.getData());
    }

    public int findLCAtwoNodes(TreeNode root, int t1, int t2) {
        if(root == null){
            return -1;
        }
        if(root.getData() == t1)
            return t1;
        if(root.getData() == t2)
            return t2;
        int left = findLCAtwoNodes(root.getLeft(), t1, t2);
        int right = findLCAtwoNodes(root.getRight(), t1, t2);
        if(left != -1 && right != -1){
            return root.getData();
        }else if(left == -1 && right != -1){
            return right;
        }else{
            return left;
        }

    }

    public TreeNode findLCAtwoNodesOptimal(TreeNode node, int t1, int t2) {
        if(node == null || node.getData() == t1 || node.getData() == t2){
            return node;
        }
        TreeNode left = findLCAtwoNodesOptimal(node.getLeft(), t1, t2);
        TreeNode right = findLCAtwoNodesOptimal(node.getRight(), t1, t2);
        if(left == null)
            return right;
        else if(right == null)
            return left;
        else return node;
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
