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
Delete a Linked List node at a given position
Given a singly linked list and a position, delete a linked list node at the given position.
Example:
Input: position = 1, Linked List = 8->2->3->1->7
Output: Linked List =  8->3->1->7
Input: position = 0, Linked List = 8->2->3->1->7
Output: Linked List = 2->3->1->7
*/
public class DeleteALinkedListNodeAtAGivenPosition
{
    public static void deleteAtPos(int pos,Linked_List ll)
    {
        if(ll==null)
            return;
        Node parent=null,todelete=ll.head,temp=ll.head;
        while(temp!=null&&pos>1)
        {
            parent=temp;
            temp=temp.next;
            pos--;
        }
        todelete=temp;
        if(temp==null)
            return;//pos was too much
        if(parent==null)//head is to be deleted
        {
            ll.head=ll.head.next;
            return;
        }
        parent.next=todelete.next;
    }
    public static void main(String[] args)
    {
        Linked_List l=new Linked_List();
        l.addRandomN(10);
        deleteAtPos(11,l);
        l.printNodes();
    }
}
