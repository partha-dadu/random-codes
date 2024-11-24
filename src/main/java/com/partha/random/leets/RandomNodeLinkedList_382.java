package com.partha.random.leets;

import java.util.ArrayList;
import java.util.List;

public class RandomNodeLinkedList_382 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(4,node3);
        ListNode node5 = new ListNode(5,node4);

        RandomNodeLinkedList_382 randomNodeLinkedList382 = new RandomNodeLinkedList_382();
        randomNodeLinkedList382.solution(node5);
        System.out.println(randomNodeLinkedList382.getRandom());
    }

      List<Integer> list = new ArrayList<>();
    public void solution(ListNode head) {
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        double random = Math.random();
        int newRandomIndex =(int) (random*list.size());
        return list.get(newRandomIndex);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
