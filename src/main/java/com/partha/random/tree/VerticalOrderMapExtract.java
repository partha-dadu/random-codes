package com.partha.random.tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderMapExtract {

    class TupleNode{
        TreeNode node;
        int level;
        int vertical;
        TupleNode(TreeNode node, int level, int vertical){
            this.node = node;
            this.level = level;
            this.vertical = vertical;
        }

    }

    public static void main(String[] args) {
        VerticalOrderMapExtract obj = new VerticalOrderMapExtract();
        obj.buildVerticalOrderTraversal(obj.buildTree());
    }


    public List<List<Integer>> buildVerticalOrderTraversal(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Map<Integer, Map<Integer, List<TreeNode>>> map = new TreeMap<>();
        Queue<TupleNode> queue = new LinkedList<>();
        queue.add(new TupleNode(node, 0, 0));
        while (!queue.isEmpty()) {
            TupleNode current = queue.poll();
            if(current.node.getLeft() != null){
                queue.offer(new TupleNode(current.node.getLeft(), current.level + 1, current.vertical-1));
            }
            if(current.node.getRight() != null){
                queue.offer(new TupleNode(current.node.getRight(), current.level + 1, current.vertical+1));
            }
            handleInsertionMap(map, current.vertical, current.level, current.node);
        }
        for(Map<Integer, List<TreeNode>> eachVertical : map.values()){
            result.add(new ArrayList<>());
            for(List<TreeNode> list : eachVertical.values()){
                result.get(result.size()-1).addAll(list.stream().map(TreeNode::getData).collect(Collectors.toList()));
                result.get(result.size() - 1).sort(Comparator.naturalOrder());
            }
        }
        return  result;
    }

    public void handleInsertionMap(Map<Integer, Map<Integer, List<TreeNode>>> parent, int vertical, int level, TreeNode node){
        if(parent.containsKey(vertical)){
            Map<Integer, List<TreeNode>> map = parent.get(vertical);
            if(map.containsKey(level)){
                map.get(level).add(node);
            }else{
                List<TreeNode> list = new ArrayList<>();
                list.add(node);
                map.put(level, list);
            }
        }else{
            Map<Integer, List<TreeNode>> map = new TreeMap<>();
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            map.put(level, list);
            parent.put(vertical, map);
        }
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
