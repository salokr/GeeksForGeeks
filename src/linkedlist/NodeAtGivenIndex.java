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
public class NodeAtGivenIndex 
{
    public static int getNthData(Node head,int pos)
    {
        Node start=head;
        while(pos>0)
        {
            start=start.next;
            pos--;
        }
        return head.data;
    }
}
