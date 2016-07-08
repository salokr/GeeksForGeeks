/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
public class GivenALinkedListWhichIsSortedHowWillYouInsertInSortedWay
{
    public static void addSorted(Linked_List ll,int newval)
    {
        Node head=ll.head,parent=null;
        while(head!=null&&head.data<newval)
        {
            parent=head;
            head=head.next;
        }
        Node newnoad=new Node(newval);
        newnoad.next=head;
        if(parent==null)
            ll.head=newnoad;
        else
        {
            parent.next=newnoad;
            newnoad.next=head;
        }
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addSortedN(10);
        Scanner sc=new Scanner(System.in);
        int t=5;
        while(t>0)
        {
            int n=sc.nextInt();
            addSorted(ll,n);
        }
    }
}
