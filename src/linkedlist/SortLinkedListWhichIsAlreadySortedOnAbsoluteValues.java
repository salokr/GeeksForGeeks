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
public class SortLinkedListWhichIsAlreadySortedOnAbsoluteValues
{
    public static void sortList(Linked_List ll)
    {
        Node parent=ll.head,start=parent.next;
        while(start!=null)
        {
            if(start.data<parent.data)
            {
                Node temp=start.next;
                parent.next=temp;
                start.next=ll.head;
                ll.head=start;
                start=temp;
            }
            else
            {
                parent=start;
                start=start.next;
            }
        
        }
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addAtEnd(0);
        ll.addAtEnd(1);
        ll.addAtEnd(-2);
        ll.addAtEnd(3);
        ll.addAtEnd(4);
        ll.addAtEnd(5);
        ll.addAtEnd(-5);
        sortList(ll);
    }
}
