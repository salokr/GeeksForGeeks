/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.HashSet;

/**
 *
 * @author ashutosh
 */
public class UnionAndIntersectionOfTwoLinkedLists
{
    public static void findUnion(Linked_List l1,Linked_List l2)
    {
        HashSet<Integer> added=new HashSet<>();
        Linked_List union=new Linked_List();
        Node start=l1.head;
        while(start!=null)
        {
            if(!added.contains(start.data))
            {
                added.add(start.data);
                union.addAtEnd(start.data);
            }
            start=start.next;
        }
        start=l2.head;
        while(start!=null)
        {
            if(!added.contains(start.data))
            {
                added.add(start.data);
                union.addAtEnd(start.data);
            }
            start=start.next;
        }
        union.printNodes();
    }
    public static void findIntersection(Linked_List l1,Linked_List l2)
    {
        HashSet<Integer> added=new HashSet<>();
        Linked_List intersection=new Linked_List();
        Node start=l1.head;
        while(start!=null)
        {
            added.add(start.data);
            start=start.next;
        }
        start=l2.head;
        while(start!=null)
        {
            if(added.contains(start.data))
                intersection.addAtEnd(start.data);
            start=start.next;
        }
        intersection.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List l1=new Linked_List();
        Linked_List l2=new Linked_List();
        l1.addRandomN(10);l2.addRandomN(20);
        findUnion(l1, l2);
        findIntersection(l1, l2);
    }
}
