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
Move last element to front of a given Linked List
Write a C function that moves last element to front in a given Singly Linked List. For example, 
if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.

Algorithm:
Traverse the list till last node. Use two pointers: one to store the address of last node and other 
for address of second last node. After the end of loop do following operations.
i) Make second last as last (secLast->next = NULL).
ii) Set next of last as head (last->next = *head_ref).
iii) Make last as head ( *head_ref = last)
*/
public class MoveLastElementToFrontOfAGivenLinkedList
{
    public static void moveLastToFront(Linked_List ll)
    {
        if(ll.head==null)
            return;
        Node start=ll.head,parent=null;
        while(start.next!=null)
        {
            parent=start;
            start=start.next;
        }
        if(parent==null)//if only one node
            return;
        parent.next=null;
        start.next=ll.head;
        ll.head=start;
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(10);
        moveLastToFront(ll);
    }
}
