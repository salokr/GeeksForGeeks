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
Merge two sorted linked lists
Write a SortedMerge() function that takes two lists, each of which is sorted in increasing order, 
and merges the two together into one list which is in increasing order. 
SortedMerge() should return the new list. The new list should be made by splicing
together the nodes of the first two lists.
For example if the first linked list a is 5->10->15 and the other linked list b is
2->3->20, then SortedMerge() should return a pointer to the head node of the merged list 2->3->5->10->15->20.
There are many cases to deal with: either ‘a’ or ‘b’ may be empty, 
during processing either ‘a’ or ‘b’ may run out first, 
and finally there’s the problem of starting the result list empty, and building it up while going through ‘a’ and ‘b’.
*/
public class MergeTwoSortedLinkedLists 
{
    public static void mergeList(Linked_List l1,Linked_List l2)
    {
        Linked_List mergedlist=new Linked_List();
        Node head1=l1.head,head2=l2.head;
        while(head1!=null&&head2!=null)
        {
            if(head1.data<head2.data)
            {
                mergedlist.addAtEnd(head1.data);
                head1=head1.next;
            }
            else
            {
                mergedlist.addAtEnd(head2.data);
                head2=head2.next;
            }
        }
        while(head1!=null)
        {
            mergedlist.addAtEnd(head1.data);
            head1=head1.next;
        }
        while(head2!=null)
        {
            mergedlist.addAtEnd(head2.data);
            head2=head2.next;
        }
        /*
        No Need To use those two while loops 
        when one list has reach end we can just change the next pointer of mergedlist to current of other one.
        */
        mergedlist.printNodes();
    }
    public static void main(String[] rags)
    {
        Linked_List l1=new Linked_List();
        Linked_List l2=new Linked_List();
        l1.addSortedN(4);
        l2.addSortedN(6);
        mergeList(l1, l2);
    }
}
