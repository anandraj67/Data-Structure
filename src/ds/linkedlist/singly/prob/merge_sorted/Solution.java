package ds.linkedlist.singly.prob.merge_sorted;

import ds.linkedlist.singly.Node;
import ds.linkedlist.singly.SingleLinkedList;

public class Solution {
    /**
     *
     * @Sawal
     * Merge to sorted linked list
     * ll1: 2 4
     * ll2: 1 3 5
     * @Jawab
     * Take a last pointer and 2 iterators
     * Move the iterator which is of lower value.
     */
    public SingleLinkedList<Integer> merge_sorted_linked_lists(SingleLinkedList<Integer> ll1, SingleLinkedList<Integer> ll2){
        Node<Integer> iter1 = ll1.head;
        Node<Integer> iter2 = ll2.head;
        SingleLinkedList<Integer> ll = new SingleLinkedList<Integer>();
        if(iter1 == null || iter2 == null){
            ll.head = (iter1 == null ) ? iter2 : iter1;
        }else{
            ll.head = (iter1.data > iter2.data) ? iter2 : iter1;
        }
        ll1.head = null;
        ll2.head = null;
        Node<Integer> last = null;
        while (iter1!=null && iter2!=null){
            if(iter1.data < iter2.data){
                if (last!=null)
                    last.next = iter1;
                last = iter1;
                iter1 = iter1.next;
            }else if(iter2.data < iter1.data) {
                if (last!=null)
                    last.next = iter2;
                last = iter2;
                iter2 = iter2.next;
            }
        }
        if(last!= null){
            last.next = (iter1==null)? iter2:iter1;
        }
        return ll;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> ll1 = new SingleLinkedList<Integer>();
        ll1.insert_end(new Node<Integer>(2));
        ll1.insert_end(new Node<Integer>(4));
        ll1.insert_end(new Node<Integer>(6));

        SingleLinkedList<Integer> ll2 = new SingleLinkedList<Integer>();
        ll2.insert_end(new Node<Integer>(3));
        ll2.insert_end(new Node<Integer>(5));
        ll2.insert_end(new Node<Integer>(7));
        ll2.insert_end(new Node<Integer>(9));

        Solution solution = new Solution();
        SingleLinkedList<Integer> ll = solution.merge_sorted_linked_lists(ll1, ll2);
        ll.print();
    }
}
