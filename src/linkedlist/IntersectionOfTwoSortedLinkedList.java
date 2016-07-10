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

public class IntersectionOfTwoSortedLinkedList
{
    Linked_List llist3=new Linked_List();
    void getIntersection(Node head1, Node head2)
    {
        Node end=null;
        while(head1!=null&&head2!=null)
        {
            int currdata;
            if(head1.data<head2.data)
            {
                head1=head1.next;
                continue;
            }
            else if(head1.data>head2.data)
            {
                head2=head2.next;
                continue;
            }
            else
            {
                currdata=head1.data;
                while(head1!=null&&head1.data==currdata)
                    head1=head1.next;
                while(head2!=null&&head2.data==currdata)
                    head2=head2.next;
            }
            Node newnode=new Node(currdata);
            if(llist3.head==null)
            {
                llist3.head=newnode;
                end=llist3.head;
            }
            else
            {
                end.next=newnode;
                end=newnode;
            }
        }
        System.out.println("Ka be");
        llist3.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll1=new Linked_List();
        Linked_List ll2=new Linked_List();
        ll1.addRepeatNSortedN(100);
        ll2.addRepeatNSortedN(25);
        IntersectionOfTwoSortedLinkedList itsll=new IntersectionOfTwoSortedLinkedList();
        itsll.getIntersection(ll1.head,ll2.head);
    }
}
