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
Segregate even and odd nodes in a Linked List
Given a Linked List of integers, write a function to modify the linked list such that 
all even numbers appear before all the odd numbers in the modified linked list. 
Also, keep the order of even and odd numbers same.
Examples:
Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL
Input: 8->12->10->5->4->1->6->NULL
Output: 8->12->10->4->6->5->1->NULL
// If all numbers are even then do not change the list
Input: 8->12->10->NULL
Output: 8->12->10->NULL
// If all numbers are odd then do not change the list
Input: 1->3->5->7->NULL
Output: 1->3->5->7->NULL
*/
public class SegregateOddAndEven
{
    public static void segregate(Linked_List ll)
    {
        //check for nullity is required here
        Node end=ll.head;
        if(end==null)
            return;
        while(end.next!=null)
            end=end.next;
        Node originalend=end;
        Node start=ll.head,preveven;
        //move all odd before first even to last, to decide Head
        while(start!=originalend&&start.data%2==1)
        {
            Node current=start;
            start=start.next;
            end.next=current;
            current.next=null;
            end=current;
        }
        //start currently points to first even, IF PRESENT
        if(start.data%2==1)//all odd were in current list, means either we have reached original end or we got first even, but if this condition
        {//is true then we are at original end and current is odd otherwise we could have breaked at first even number.
            end.next=start;
            start.next=null;
            return;
        }
        ll.head=start;
        preveven=start;
        while(start!=originalend)
        {
            if(start.data%2==0)
            {
                preveven=start;
                start=start.next;
            }
            else
            {
                Node temp=start;
                start=preveven.next=start.next;
                end.next=temp;
                end=temp;
                end.next=null;
            }
            
        }
        //start is at original end
        if(start.data%2==1&&start!=originalend)
        {
            preveven.next=start.next;
            end.next=start;
            end=start;
            end.next=null;
            
        }
    }
    public static void main(String[] arsg)
    {
        //System.out.println(Integer.MAX_VALUE);
        int t=10;
        Scanner sc=new Scanner(System.in);
        while(t>0)
        {
            Linked_List ll=new Linked_List();
            ll.addRandomN(sc.nextInt());
            segregate(ll);
            ll.printNodes();
            t--;
        }
    }
}
