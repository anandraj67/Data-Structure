package ds.linkedlist.singly;

import java.util.HashMap;
import java.util.Map;

public class SingleLinkedList<Type> {
	public Node<Type> head;

	public SingleLinkedList(){
		head = null;
	}
    public void insert_beginning(Node<Type> newNode){
        newNode.next = head;
        head = newNode;
    }
    public void insert_end(Node<Type> newNode){
        newNode.next = null;
        if( isEmpty() )
            head = newNode;
        else
        {
            // OR last.next= newNode; last = newNode;
            Node<Type> iterator = head;
            while(iterator.next != null)
                iterator = iterator.next;
            iterator.next = newNode;
        }
    }
    public void insert_after(Node<Type> newNode,Node<Type> after){
        //todo
    }
    public void insert_at_position(int position, Node<Type> newNode){
        if(position > SingleLinkedList.this.size())
            return;
        if(position==0){
            newNode.next = head;
            head = newNode;
        }else{
            Node<Type> iter = head;
            while (position>1){
                iter = iter.next;
                position--;
            }
            newNode.next = iter.next;
            iter.next = newNode;
        }
    }
    public void delete_beginning(){
        if(!isEmpty())
            head = head.next;
    }
    public void delete_end(){
        if( head == null || head.next == null)
        {
            head = null;
        }
        else
        {
            Node<Type> iterator = head;
            while(iterator.next.next != null)
                iterator = iterator.next;
            iterator.next = null;
        }
    }
    public void delete_node(Node<Type> node){
        //todo
    }
    public void delete_at_position(int position){
        //todo
    }
	public int size(){
		Node<Type> iterator = head;
		int len= 0 ;
		while(iterator != null)
		{
			len++;
			iterator=iterator.next;
		}
		return len;
	}
	public static int size(Node head){
		Node iterator = head;
		int len= 0 ;
		while(iterator != null)
		{
			len++;
			iterator=iterator.next;
		}
		return len;
	}
	public boolean isEmpty(){
		return (head == null);
	}
	public void print(){
		Node<Type> node = this.head;
		while(node != null)
		{
			node.print();
			node = node.next;
		}
		System.out.println(" ");
	}
    public void printRandomOrder(){
        System.out.println("The linked list in Random order is : ");
        Node<Type> iter = this.head;
        while(iter != null)
        {
            System.out.print(iter.data +" ");
            iter = iter.random;
        }
        System.out.println(" ");
    }
}
