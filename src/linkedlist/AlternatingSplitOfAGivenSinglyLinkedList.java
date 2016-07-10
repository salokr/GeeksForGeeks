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
Alternating split of a given Singly Linked List
Write a function AlternatingSplit() that takes one list and divides up its nodes to make two smaller lists ‘a’ and ‘b’. 
The sublists should be made from alternating elements in the original list. 
So if the original list is 0->1->0->1->0->1 then one sublist should be 0->0->0 and the other should be 1->1->1.
*/
public class AlternatingSplitOfAGivenSinglyLinkedList
{
    public static void split(Linked_List l1)
    {
        Linked_List l2=new Linked_List();
        Node start=l1.head;
        while(start!=null&&start.next!=null)
        {
            int data=start.next.data;
            l2.addAtEnd(data);
            start.next=start.next.next;
            start=start.next;
        }
        l2.printNodes();
        l1.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(10);
        split(ll);
        ll=null;
        ll=new Linked_List();
        ll.addRandomN(11);
        split(ll);
    }
}
