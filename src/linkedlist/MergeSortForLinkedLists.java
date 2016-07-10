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
public class MergeSortForLinkedLists
{
    public static void merge(Node head1,Node head2,Linked_List ll)
    {
        Linked_List sorted=new Linked_List();
        while(head1!=null&&head2!=null)
        {
            if(head1.data<head2.data)
            {
                sorted.addAtEnd(head1.data);
                head1=head1.next;
            }
            else
            {
                sorted.addAtEnd(head2.data);
                head2=head2.next;
            }
        }
        if(head1!=null)
            sorted.mergeNode(head1);
        if(head2!=null)
            sorted.mergeNode(head2);
        //sorted.printNodes();
        ll.head=sorted.head;
    }
    public static void doMergeSort(Linked_List ll)
    {
        if(ll==null||ll.head==null||ll.head.next==null)
            return;
        linkedlists lists=splitIntoTwo(ll);
        doMergeSort(lists.l1);
        doMergeSort(lists.l2);
        merge(lists.l1.head,lists.l2.head,ll);
    }
    public static linkedlists splitIntoTwo(Linked_List ll)
    {
        Node start=ll.head;
        Node head1,head2;
        if(start==null||start.next==null)
            return new linkedlists(ll,null);
        Node slow=start,fast=start;
        while(fast!=null)
        {
            fast=fast.next;
            if(fast!=null&&fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next;
            }
        }
        head2=slow.next;
        head1=start;slow.next=null;
        Linked_List l1=new Linked_List(),l2=new Linked_List();
        l1.head=head1;l2.head=head2;
        return new linkedlists(l1,l2);
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(11);
        doMergeSort(ll);
        ll.printNodes();
    }
}
class linkedlists
{
    Linked_List l1,l2;
    public linkedlists(Linked_List l1,Linked_List l2)
    {
        this.l1=l1;
        this.l2=l2;
    }
}