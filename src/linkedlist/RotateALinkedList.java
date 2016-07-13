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
/*
Rotate a Linked List
Given a singly linked list, rotate the linked list counter-clockwise by k nodes.
Where k is a given positive integer. For example, if the given linked list is 10->20->30->40->50->60 and k is 4, 
the list should be modified to 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in linked list.
*/

public class RotateALinkedList
{
    public static void rotateLL(Linked_List ll,int key)
    {
        Node head=ll.head,start=ll.head;
        while(start!=null&&key>1)
        {
            start=start.next;
            key--;
        }
        if(start==null||start.next==null)
            return;
        ll.head=start.next;
        start.next=null;
        Node temp=ll.head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=head;
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(10);
        rotateLL(ll, 4);
        ll.printNodes();
    }
}
