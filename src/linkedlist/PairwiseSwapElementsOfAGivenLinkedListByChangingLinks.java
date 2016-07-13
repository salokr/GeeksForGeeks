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
Pairwise swap elements of a given linked list by changing links
Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list
is 1->2->3->4->5->6->7 then the function should change it to 2->1->4->3->6->5->7, 
and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
*/

public class PairwiseSwapElementsOfAGivenLinkedListByChangingLinks
{
    public static void pairwiseSwap(Linked_List ll)
    {
        Node current=ll.head,next,prev=null;
        if(current==null||current.next==null)
            return;
        while(current!=null&&current.next!=null)
        {
            next=current.next;
            current.next=next.next;
            next.next=current;
            if(prev==null)
                ll.head=next;
            else
                prev.next=next;
            prev=current;
            current=current.next;
        }
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(7);
        pairwiseSwap(ll);
        ll.addAtEnd(10);
        ll.printNodes();
        pairwiseSwap(ll);
    }
}
