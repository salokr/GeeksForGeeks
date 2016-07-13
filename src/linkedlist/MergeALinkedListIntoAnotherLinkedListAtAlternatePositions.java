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
Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, the first list should 
become 5->12->7->10->17->2->13->4->11->6 and second list should become empty. The nodes of second list should only
be inserted when there are positions available. For example, if the first list is 1->2->3 and second list is 4->5->6->7->8, then first
list should become 1->4->2->5->3->6 and second list to 7->8.
Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place.
Expected time complexity is O(n) where n is number of nodes in first list.
*/

public class MergeALinkedListIntoAnotherLinkedListAtAlternatePositions
{
    public static void mergeAlternate(Linked_List l1,Linked_List l2)
    {
        Node head1=l1.head,head2=l2.head,temp1,temp2;
        while(head1!=null&&head2!=null)
        {
            temp1=head2.next;
            temp2=head1.next;
            head2.next=head1.next;
            head1.next=head2;
            head2=temp1;
            head1=temp2;
        }
        l1.printNodes();
        l2.head=head2;
        l2.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll1=new Linked_List();
        Linked_List ll2=new Linked_List();
        ll1.addRandomN(5);ll2.addRandomN(5);
        mergeAlternate(ll1, ll2);
    }
}
