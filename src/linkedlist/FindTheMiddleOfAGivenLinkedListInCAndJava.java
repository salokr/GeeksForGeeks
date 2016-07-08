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
Find the middle of a given linked list in C and Java
Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.

If there are even nodes, then there would be two middle nodes, we need to print second middle element. 
For example, if given linked list is 1->2->3->4->5->6 then output should be 4.

Method 1:
Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2.

Method 2:
Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
When the fast pointer reaches end slow pointer will reach middle of the linked list.
*/

/*
The IDEA here is like this

currentpos              fastpos
1                       2
2                       4
3                       6
4                       8
5                       10
.                       .
.                       .
.                       .
.                       .
n                       2n
i.e. move fast to double of slow
*/

public class FindTheMiddleOfAGivenLinkedListInCAndJava
{
    public static int getMiddle(Node head)
    {
        if(head==null)
            return Integer.MIN_VALUE;//error value
        Node fast=head,slow=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    public static void main(String[] args)
    {
        Linked_List ll1=new Linked_List();
        ll1.addRandomN(10);
        System.out.println(getMiddle(ll1.head));
        Linked_List ll2=new Linked_List();
        ll2.addRandomN(11);
        System.out.println(getMiddle(ll2.head));
    }
}
