/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author ashutosh
 */
public class InsertionSortForSinglyLinkedList 
{
    public static void addSorted(Linked_List ll,int key)
    {
        Node head=ll.head;
        Node newnode=new Node(key);
        if(head==null)
        {
            ll.head=newnode;
            return;
        }
        Node parent=null;
        while(head!=null&&key>head.data)
        {
            parent=head;
            head=head.next;
        }
        if(parent==null)
        {
            newnode.next=ll.head;
            ll.head=newnode;
            return;
        }
        newnode.next=head;
        parent.next=newnode;
    }
    public static void doInsertionSort(Linked_List ll)
    {
        Node head=ll.head;
        Linked_List sorted=new Linked_List();
        while(head!=null)
        {
            int key=head.data;
            addSorted(sorted,key);
            head=head.next;
        }
        sorted.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(10);
        doInsertionSort(ll);
    }
}
