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


public class RemoveDuplicatesFromASortedLinkedList
{
    public static void removeDuplicates(Linked_List ll)
    {
        Node start=ll.head,parent=ll.head;
        while(start!=null)
        {
            if(start.next!=null&&start.data==start.next.data)
            {
                parent=start;
                while(start!=null&&start.data==parent.data)
                    start=start.next;
                parent.next=start;
            }
            else start=start.next;
        }
        System.out.println("Modified");
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRepeatNSortedN(20);
        removeDuplicates(ll);
    }
}
