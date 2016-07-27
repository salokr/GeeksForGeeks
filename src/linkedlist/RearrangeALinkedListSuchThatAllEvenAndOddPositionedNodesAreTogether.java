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
Rearrange a linked list such that all even and odd positioned nodes are together
Rearrange a linked list in such a way that all odd position nodes are together and all even positions node are together,
Examples:
Input:   1->2->3->4
Output:  1->3->2->4
Input:   10->22->30->43->56->70
Output:  10->30->56->22->43->70
*/
public class RearrangeALinkedListSuchThatAllEvenAndOddPositionedNodesAreTogether
{
    public static void rearrange(Linked_List ll)
    {
        Node evenend=ll.head,head=ll.head,oddstart=null,oddend=null;
        if(head==null)
            return;
        while(evenend!=null&&evenend.data%2==1)
            evenend=evenend.next;
        //if all odd node no need to go further
        if(evenend==null)
            return;
        //now start from head if odd continue to next node else join previous to current's next.
        //case to handle when head needs to be changed
        //make first even as head node too.
        ll.head=evenend;
        while(head!=null)
        {
            if(head.data%2==0)
            {
                if(evenend!=head)//avoid first even to avoid self loop
                    evenend.next=head;
                evenend=head;//move end to current
            }
            else
            {
                if(oddstart==null)//first time initizlization off odd start
                    oddstart=head;
                else
                    oddend.next=head;//else attach new odd to previous oddend
                oddend=head;//move odd end ahead
            }
            head=head.next;//forward head
        }
        evenend.next=oddstart;//join evenend to oddstart
        if(oddend!=null)
            oddend.next=null;//make last node's next as null
    ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(3);
        rearrange(ll);
    }
}
