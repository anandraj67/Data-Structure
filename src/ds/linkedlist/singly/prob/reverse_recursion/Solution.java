package ds.linkedlist.singly.prob.reverse_recursion;

import ds.linkedlist.singly.Node;
import ds.linkedlist.singly.SingleLinkedList;

public class Solution {

    /**
     * @Sawal
     * 	Reverse a linked list with Recursion
     * @Jawab
     * 	Base case : null or single node.
     * 	Recursively call for next node.
     *	After returning link reversed last to node
     *		and  node to null.
     *	Every recursive step is returning head of reversed.
     */
    public Node reverseRecurssion(Node node) {
        if(node == null || node.next == null) 	// Base case
            return node;
        Node nodeReturned = reverseRecurssion(node.next);
        node.next.next = node;
        node.next =null;
        return nodeReturned;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.insert_end(new Node<Integer>(1));
        singleLinkedList.insert_end(new Node<Integer>(2));
        singleLinkedList.insert_end(new Node<Integer>(3));
        singleLinkedList.insert_end(new Node<Integer>(4));
        singleLinkedList.insert_end(new Node<Integer>(5));
        singleLinkedList.insert_end(new Node<Integer>(6));
        singleLinkedList.insert_end(new Node<Integer>(7));
        singleLinkedList.print();
        Solution solution = new Solution();
        Node newHead = solution.reverseRecurssion(singleLinkedList.head);
        singleLinkedList.head = newHead;
        System.out.println("After reversal");
        singleLinkedList.print();
    }

}
