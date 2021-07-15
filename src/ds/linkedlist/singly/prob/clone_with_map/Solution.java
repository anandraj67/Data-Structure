package ds.linkedlist.singly.prob.clone_with_map;

import ds.linkedlist.singly.Node;
import ds.linkedlist.singly.SingleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @Sawal
     * 	Makes a copy of the random pointer linked list.
     * @Jawab
     * 	Copy the normal pointer and keep the
     * 		mapping of original to  new node in Hash map.
     * 	Then iterate again and fix the random pointer.
     */
    public Node cloneWithHashMapHelp(Node head){
        Node originalNode = head;
        Map<Node, Node> map = new HashMap();
        Node clonedNode = null;
        Node clonedHead = null;

        // Loop for normal pointer and saving the map
        while(originalNode!=null)
        {
            Node newClonedNode = new Node(originalNode.data);
            if(clonedHead == null) clonedHead = newClonedNode;
            else clonedNode.next =  newClonedNode;
            map.put(originalNode, newClonedNode);
            originalNode = originalNode.next;
            clonedNode = newClonedNode;
        }

        originalNode = head;
        // Loop for random pointer
        while(originalNode != null)
        {
            map.get(originalNode).random = map.get( originalNode.random );
            originalNode = originalNode.next;
        }
        return clonedHead;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> llRandom = new SingleLinkedList();
        llRandom.insert_end(new Node<Integer>(1)); 		llRandom.insert_end(new Node<Integer>(2));
        llRandom.insert_end(new Node<Integer>(3)); 		llRandom.insert_end(new Node<Integer>(4));
        llRandom.insert_end(new Node<Integer>(5));
        llRandom.head.random = llRandom.head.next.next;
        llRandom.head.next.next.random = llRandom.head.next.next.next.next;
        llRandom.head.next.next.next.next.random = llRandom.head.next.next.next;
        llRandom.head.next.next.next.random = llRandom.head.next;
        llRandom.head.next.random = null;
        llRandom.print(); //NormalOrder
        llRandom.printRandomOrder();

        Solution solution = new Solution();
        SingleLinkedList<Integer> llRandomCloned = new SingleLinkedList();
        llRandomCloned.head = solution.cloneWithHashMapHelp(llRandom.head);

        llRandomCloned.print(); //NormalOrder
        llRandomCloned.printRandomOrder();
    }
}
