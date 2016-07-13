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
public class SortALinkedListOf0s1sAnd2s
{
    public static Node partitionList(Node begin,int pivot)
    {
        if(begin==null||begin.next==null)
            return begin;
        Node last=begin;
        while(begin!=null)
        {
            if(begin.data<pivot)
            {
                int temp=last.data;
                last.data=begin.data;
                begin.data=temp;
                last=last.next;
            }
            begin=begin.next;
        }
        return last;
    }
    public static void sortList(Linked_List ll)
    {
        Node begin;
        begin=partitionList(ll.head, 1);
        partitionList(begin,2);
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List l1=new Linked_List();
        l1.addAtEnd(0);
        l1.addAtEnd(1);
        l1.addAtEnd(0);
        l1.addAtEnd(2);
        l1.addAtEnd(1);
        l1.addAtEnd(1);
        l1.addAtEnd(2);
        l1.addAtEnd(1);
        l1.addAtEnd(2);
        sortList(l1);
    }
}
