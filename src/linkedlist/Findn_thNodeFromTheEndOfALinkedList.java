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
Find n’th node from the end of a Linked List
Given a Linked List and a number n, write a function that returns the value at the n’th node from end of the Linked List.
*/
public class Findn_thNodeFromTheEndOfALinkedList
{
    public static void findNthFormLast(int n,Node head)
    {
        Node newhead=head,pointer=head;
        while(pointer!=null&&n>0)
        {
            n--;
            pointer=pointer.next;
        }
        if(pointer==null)
        {
            System.out.println("Node Not Available");//or -1 whatever
            return;
        }
        while(pointer!=null)
        {
            pointer=pointer.next;
            newhead=newhead.next;
        }
        System.out.println("Nth From End: "+newhead.data);
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(50);
        findNthFormLast(2,ll.head);
    }
}
