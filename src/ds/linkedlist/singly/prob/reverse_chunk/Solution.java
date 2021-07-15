package ds.linkedlist.singly.prob.reverse_chunk;

import ds.linkedlist.singly.Node;
import ds.linkedlist.singly.SingleLinkedList;

public class Solution {
    /**
     * @Sawal
     *  Reverse linked list in chunk
     * @Jawab
     *  3 pointers for internal reversal.
     *  At the end of 2nd chunk. 1st and 2nd will be connected.
     *  So keeping 2 chunkVariables.
     */
    public Node<Integer> reverseInChunkIterIter(Node<Integer> head, int chunkSize){
        Node<Integer> first = null;
        Node<Integer> second = head;
        Node<Integer> third ;
        Node<Integer> chunkFirst = head ;
        Node<Integer> chunkSecond = null;
        int k = chunkSize;
        boolean isFirstPass = true;
        // (1 2 3) (4 5 6) (7 8 9 ) 8 3
        while(second != null)
        {
            third = second.next;
            second.next = first;
            first = second;
            second = third;
            k--;
            if(k==0 || second == null)
            {
                if(isFirstPass == true)
                {
                    head = first;
                    isFirstPass = false;
                }
                else
                {
                    chunkFirst.next = first;
                    chunkFirst = chunkSecond;
                }
                chunkSecond = second;
                k = chunkSize;
                first = null;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList();
        singleLinkedList.insert_end(new Node(1));
        singleLinkedList.insert_end(new Node(2));
        singleLinkedList.insert_end(new Node(3));
        singleLinkedList.insert_end(new Node(4));
        singleLinkedList.insert_end(new Node(5));
        singleLinkedList.insert_end(new Node(6));
        singleLinkedList.insert_end(new Node(7));
        singleLinkedList.insert_end(new Node(8));

        singleLinkedList.print();
        Solution solution = new Solution();
        singleLinkedList.head = solution.reverseInChunkIterIter(singleLinkedList.head ,3);
        System.out.println("After reversal");
        singleLinkedList.print();
    }
}
