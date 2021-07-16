package ds.linkedlist.singly.prob.reverse_iteration;

import ds.linkedlist.singly.Node;
import ds.linkedlist.singly.SingleLinkedList;

public class Solution {
    /**
     * @Sawal
     * 	Reverse a linked list with iteration
     * @Jawab
     * 	Take three pointer to null first and second
     * 	Reverse pointer of first and second
     *	Increment all three.
     */
    public Node reverseIteration(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr !=null) 		// because connection of second and
        {							// first is to be reversed
            next = curr.next;
            curr.next = prev;

            prev = curr;		// Increment
            curr = next;
        }
        return prev;
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
        Node newHead = solution.reverseIteration(singleLinkedList.head);
        SingleLinkedList<Integer> singleLinkedList1 = new SingleLinkedList<>();
        singleLinkedList1.head = newHead;
        System.out.println("After reversal");
        singleLinkedList1.print();
    }

}
