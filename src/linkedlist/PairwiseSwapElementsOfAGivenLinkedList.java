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
public class PairwiseSwapElementsOfAGivenLinkedList
{
    static void pairWiseSwap(Node head)
    {
        Node start=head;
        while(start!=null&&start.next!=null)
        {
            if(start.next!=null)
            {
                int temp=start.data;
                start.data=start.next.data;
                start.next.data=temp;
            }
            start=start.next.next;
        }
    }
    public static void main(String[] rags)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(5);
        pairWiseSwap(ll.head);
        ll.printNodes();
        ll=null;
        ll=new Linked_List();
        ll.addRandomN(6);
        pairWiseSwap(ll.head);
        ll.printNodes();
    }
}
