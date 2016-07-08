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
/*
Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. 
Swapping data of nodes may be expensive in many situations when data contains many fields.
It may be assumed that all keys in linked list are distinct.
Examples:
Input:  10->15->12->13->20->14,  x = 12, y = 20
Output: 10->15->20->13->12->14
Input:  10->15->12->13->20->14,  x = 10, y = 20
Output: 20->15->12->13->10->14
Input:  10->15->12->13->20->14,  x = 12, y = 13
Output: 10->15->13->12->20->14
*/

public class SwapNodesInALinkedListWithoutSwappingData
{
    public static void swapNodes(int key1,int key2,Linked_List ll)
    {
        Node n1=ll.head,n2=ll.head,p1=null,p2=null;
        while(n1!=null)
        {
            if(n1.data==key1)
                break;
            p1=n1;
            n1=n1.next;
        }
        while(n2!=null)
        {
            if(n2.data==key2)
                break;
            p2=n2;
            n2=n2.next;
        }
        if(n1==null||n2==null)
            return;
        if(p1==null)
            ll.head=n2;
        else p1.next=n2;
        if(p2==null)
            ll.head=n1;
        else p2.next=n1;
        Node temp=n1.next;
        n1.next=n2.next;
        n2.next=temp;
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        for(int i=1;i<=10;i++)
            ll.addAtEnd((int)(Math.random()*100));
        ll.printNodes();
        Scanner sc=new Scanner(System.in);
        int key1=sc.nextInt();
        int key2=sc.nextInt();
        swapNodes(key1, key2, ll);
        ll.printNodes();
    }
}
