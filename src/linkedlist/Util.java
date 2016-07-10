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
