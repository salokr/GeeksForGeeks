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
Delete alternate nodes of a Linked List
Given a Singly Linked List, starting from the second node delete all alternate nodes of it. 
For example, if the given linked list is 1->2->3->4->5 then your function should convert it to 1->3->5, 
and if the given linked list is 1->2->3->4 then convert it to 1->3.
*/
public class DeleteAlternateNodesOfALinkedList
{
    public static void deleteAlternate(Linked_List ll)
    {
        Node start=ll.head;
        while(start!=null&&start.next!=null)
        {
            start.next=start.next.next;
            start=start.next;
        }
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(5);
        deleteAlternate(ll);
        ll.printNodes();
        ll=null;
        ll=new Linked_List();
        ll.addRandomN(4);
        deleteAlternate(ll);
        ll.printNodes();
    }
}
