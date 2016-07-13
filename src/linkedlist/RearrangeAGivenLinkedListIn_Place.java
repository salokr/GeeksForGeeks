package linkedlist;


import linkedlist.Linked_List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 */
/*
Rearrange a given linked list in-place.
Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. 
Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
You are required do this in-place without altering the nodes’ values.
Examples:
Input:  1 -> 2 -> 3 -> 4
Output: 1 -> 4 -> 2 -> 3
Input:  1 -> 2 -> 3 -> 4 -> 5
Output: 1 -> 5 -> 2 -> 4 -> 3 
*/
public class RearrangeAGivenLinkedListIn_Place
{
    public static void reArrange(Linked_List ll)
    {
        linkedlists lls=Util.splitIntoTwo(ll);
        Linked_List first=lls.l1;
        Linked_List second=lls.l2;
        Node head1=first.head;
        Node finalhead=head1;
        Node head2=Util.reverse(second.head);
        while(head1!=null)
        {
            if(head2==null)
                break;
            Node temp1=head1.next;
            Node temp2=head2.next;
            head1.next=head2;
            head2.next=temp1;
            head2=temp2;
            head1=temp1;
        }
        Util.printFromNode(finalhead);
    }
    public static void main(String[] args)
    {
        Linked_List ll1=new Linked_List();
        ll1.addSortedN(4);
        reArrange(ll1);
        Linked_List ll2=new Linked_List();
        ll2.addSortedN(5);
        reArrange(ll2);
    }
    
}
