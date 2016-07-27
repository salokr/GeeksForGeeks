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
Merge two sorted linked lists such that merged list is in reverse order
Given two linked lists sorted in increasing order. 
Merge them such a way that the result list is in decreasing order (reverse order).
Examples:
Input:  a: 5->10->15->40
        b: 2->3->20 
Output: res: 40->20->15->10->5->3->2
Input:  a: NULL
        b: 2->3->20 
Output: res: 20->3->2
*/
public class MergeTwoSortedLinkedListsSuchThatMergedListIsInReverseOrder
{
    public static void mergeInReverse(Linked_List l1,Linked_List l2)
    {
        Linked_List answer=new Linked_List();
        Node head1=l1.head;
        Node head2=l2.head;
        while(head1!=null&&head2!=null)
        {
            if(head1.data<head2.data)
            {
                answer.addAtFront(head1.data);
                head1=head1.next;
            }
            else
            {
                answer.addAtFront(head2.data);
                head2=head2.next;
            }
        }
        while(head1!=null)
        {
            answer.addAtFront(head1.data);
            head1=head1.next;
        }
        while(head2!=null)
        {
            answer.addAtFront(head2.data);
            head2=head2.next;
        }
        answer.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List l1=new Linked_List();
        Linked_List l2=new Linked_List();
        l1.addAtEnd(10);l1.addAtEnd(20);l1.addAtEnd(30);
        l2.addAtEnd(15);l2.addAtEnd(25);l2.addAtEnd(35);
        mergeInReverse(l1, l2);
    }
}
