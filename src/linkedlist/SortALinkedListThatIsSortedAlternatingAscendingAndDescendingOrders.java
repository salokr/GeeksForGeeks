/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author ashutosh
Sort a linked list that is sorted alternating ascending and descending orders?
Given a Linked List. The Linked List is in alternating ascending and descending orders. Sort the list efficiently.

Example:

Input List:   10->40->53->30->67->12->89->NULL
Output List:  10->12->30->43->53->67->89->NULL
Source: http://qa.geeksforgeeks.org/616/linked-that-sorted-alternating-ascending-descending-orders

We strongly recommend you to minimize your browser and try this yourself first.

A Simple Solution is to use Merge Sort for linked List. This solution takes O(n Log n) time.
*/
public class SortALinkedListThatIsSortedAlternatingAscendingAndDescendingOrders
{
    public static void sortList(Linked_List ll)
    {
        Linked_List decreasing=new Linked_List();
        Linked_List increasing=new Linked_List();
        if(ll.head==null)
            return;
        Node first=ll.head;
        while(first!=null&&first.next!=null)
        {
            increasing.addAtEnd(first.data);
            decreasing.addAtEnd(first.next.data);
            first=first.next.next;
        }
        if(first!=null)
            increasing.addAtEnd(first.data);
        Node reversed=Util.reverse(decreasing.head);
        
        increasing.printNodes();
        Util.printFromNode(reversed);
        
        
        Util.merge(increasing.head, reversed, ll);
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new  Linked_List();
        ll.addAtEnd(10);ll.addAtEnd(40);ll.addAtEnd(53);ll.addAtEnd(30);ll.addAtEnd(67);
        ll.addAtEnd(12);ll.addAtEnd(89);
        ll.printNodes();
        sortList(ll);
    }
}
