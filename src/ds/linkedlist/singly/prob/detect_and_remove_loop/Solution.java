package ds.linkedlist.singly.prob.detect_and_remove_loop;

import ds.linkedlist.singly.Node;
import ds.linkedlist.singly.SingleLinkedList;

public class Solution {
    /**
     * @Sawal
     * 1->2->3->4->5->6
     *       <---------
     * If loop is present in the linked list remove it.
     * @Jawab
     * 	Move one pointer slow and one fast,
     *		If loop is there both pointers will meet somewhere in the loop.
     *		If not then the second pointer will leave the list.
     * 	For removal of loop:
     * 		First count the nodes in the loop.Say d.
     * 		Keep a distance d between two pointers ,move both 1,
     * 		 they will meet at merge point.
     * 		Unlink the previous node.
     */
    boolean detectAndRemoveLoop(Node head){
        Node first = head;
        Node second = head;
        while(second != null && second.next != null )
        {
            first = first.next; // Moves one step
            second = second.next.next; // Moves two step
            if(first == second) // Now first and second both are
            {					//at same position somewhere in the loop
                Node third = head;
                do		 // length of loop
                {
                    second = second.next;
                    third = third.next;  // to point d dis away from head
                }while(second != first);

                first = head;
                while(first != third) // Both will meet a merger point
                {
                    first = first.next;
                    third = third.next;
                }
                while(third.next != first) // iterate to one node prev to mergerpoint.
                {
                    third = third.next;
                }
                third.next = null ; // unlinking the loop
                return true; // loop was there which is removed
            }
        }
        return false; // No loop is there
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
        singleLinkedList.head.next.next.next.next.next.next.next  = singleLinkedList.head.next.next.next;

        Solution solution = new Solution();
        boolean result = solution.detectAndRemoveLoop(singleLinkedList.head);
        System.out.println(result);
        singleLinkedList.print();
    }
}
