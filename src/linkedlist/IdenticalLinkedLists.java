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
Identical Linked Lists
Two Linked Lists are identical when they have same data and arrangement of data is also same. 
For example Linked lists a (1->2->3) and b(1->2->3) are identical.
Write a function to check if the given two linked lists are identical.
*/
public class IdenticalLinkedLists
{
    public static boolean areIdentical(Node curr1,Node curr2)
    {
        if(curr1==null&&curr2==null)
            return true;
        if(curr1==null&&curr2!=null)
            return false;
        if(curr2==null&&curr1!=null)
            return false;
        if(curr1.data!=curr2.data)
            return false;
        boolean result=areIdentical(curr1.next, curr2.next);
        if(!result)
            return false;
        return true;
    }
/*A MUCH CLEANER IMPLEMENTATION COPIED FROM GfG*/
boolean areIdenticalRecur(Node a, Node b)
{
    // If both lists are empty
    if (a == null && b == null)
        return true;
 
    // If both lists are not empty, then data of
    // current nodes must match, and same should
    // be recursively true for rest of the nodes.
    if (a != null && b != null)
        return (a.data == b.data) &&
               areIdenticalRecur(a.next, b.next);
 
    // If we reach here, then one of ths lists
    // is empty and other is not
    return false;
}
    public static void main(String[] args)
    {
        Linked_List l1=new Linked_List();
        Linked_List l2=new Linked_List();
        l1.addAtEnd(1);l1.addAtEnd(2);l1.addAtEnd(3);
        l2.addAtEnd(1);l2.addAtEnd(2);l2.addAtEnd(3);
        System.out.println("Are Identical ? "+areIdentical(l1.head, l2.head));
        l2.addAtEnd(4);
        System.out.println("Are Identical ? "+areIdentical(l1.head, l2.head));
        l1.addAtEnd(4);
        System.out.println("Are Identical ? "+areIdentical(l1.head, l2.head));
    }
}
