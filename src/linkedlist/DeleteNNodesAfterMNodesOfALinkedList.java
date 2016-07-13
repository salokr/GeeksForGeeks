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
Delete N nodes after M nodes of a linked list
Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same till end of the linked list.

Difficulty Level: Rookie

Examples:

Input:
M = 2, N = 2
Linked List: 1->2->3->4->5->6->7->8
Output:
Linked List: 1->2->5->6

Input:
M = 3, N = 2
Linked List: 1->2->3->4->5->6->7->8->9->10
Output:
Linked List: 1->2->3->6->7->8

Input:
M = 1, N = 1
Linked List: 1->2->3->4->5->6->7->8->9->10
Output:
Linked List: 1->3->5->7->9
*/
public class DeleteNNodesAfterMNodesOfALinkedList
{
    public static void deleteNAfterM(Linked_List ll,int m,int n)
    {
        Node start=ll.head,parent;
        int mm=m,nn=n;
        while(start!=null)
        {
            while(start!=null&&m>1)
            {
                start=start.next;
                m--;
            }
            parent=start;
            if(start==null)
                return;
            start=start.next;
            while(start!=null&&n>0)
            {
                start=start.next;
                n--;
            }
            parent.next=start;
            m=mm;n=nn;
        }
        ll.printNodes();
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addAtEnd(1);ll.addAtEnd(2);ll.addAtEnd(3);ll.addAtEnd(4);ll.addAtEnd(5);ll.addAtEnd(6);ll.addAtEnd(7);ll.addAtEnd(8);ll.addAtEnd(9);ll.addAtEnd(10);
        deleteNAfterM(ll, 1, 1);
    }
}
