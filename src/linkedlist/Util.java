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
public class Util
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
    
    public static Node reverse(Node head)
    {
        Node current=head,prev=null,nextnode;
        if(head==null)
            return null;
        while(current!=null)
        {
            nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        }
        return prev;
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
    public static void printFromNode(Node current)
    {
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
    public static void printReverse(Node current)
    {
        if(current==null)
            return;
        printReverse(current.next);
        System.out.print(current.data+" ");
    }
}
