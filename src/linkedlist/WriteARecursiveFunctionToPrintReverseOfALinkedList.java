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
public class WriteARecursiveFunctionToPrintReverseOfALinkedList
{
    public static void printReverse(Node current)
    {
        if(current==null)
            return;
        printReverse(current.next);
        System.out.print(current.data+" ");
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(10);
        printReverse(ll.head);
    }
}
