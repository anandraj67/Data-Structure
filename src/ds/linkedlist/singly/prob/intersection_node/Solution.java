package ds.linkedlist.singly.prob.intersection_node;

import ds.linkedlist.singly.Node;
import ds.linkedlist.singly.SingleLinkedList;

public class Solution {
    /**
     * @Sawal
     *  Write a function to get the intersection point of two Linked Lists.
     * @Jawab
     *  Find the difference in length of two list,say d.</br>
     *  keep 1 pointer d distance away in longer list.
     *  Both will meet at intersection point.
     */
    Node getIntersectionPoint(Node node1, Node node2){
        Node iterBig = null;
        Node iterSmall = null;
        int lenght1 = SingleLinkedList.size(node1);
        int lenght2 = SingleLinkedList.size(node2);
        if(lenght1 > lenght2)
        {
            iterBig = node1;
            iterSmall = node2;
        }
        else
        {
            iterBig = node2;
            iterSmall = node1;
        }
        int diff = Math.abs(lenght1- lenght2);
        while(diff !=0)
        {
            iterBig = iterBig.next;
            diff--;
        }
        while(iterBig != iterSmall)
        {
            iterBig = iterBig.next;
            iterSmall = iterSmall.next;
        }
        return iterBig;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> ll1 = new SingleLinkedList();
        ll1.insert_end(new Node(1));
        ll1.insert_end(new Node(2));
        ll1.insert_end(new Node(3));
        ll1.insert_end(new Node(4));
        ll1.insert_end(new Node(5));
        ll1.insert_end(new Node(6));

        SingleLinkedList<Integer> ll2 = new SingleLinkedList();
        ll2.insert_end(new Node(10));
        ll2.insert_end(new Node(20));
        ll2.head.next.next=ll1.head.next.next.next.next;

        Solution solution = new Solution();
        solution.getIntersectionPoint(ll1.head, ll2.head).print();
    }
}
