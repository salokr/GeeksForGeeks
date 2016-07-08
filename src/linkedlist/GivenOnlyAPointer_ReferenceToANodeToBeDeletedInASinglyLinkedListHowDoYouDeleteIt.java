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
Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
A simple solution is to traverse the linked list until you find the node you want to delete. 
But this solution requires pointer to the head node which contradicts the problem statement.
*/
public class GivenOnlyAPointer_ReferenceToANodeToBeDeletedInASinglyLinkedListHowDoYouDeleteIt
{
    public static void deleteNode(Node n)
    {
       Node temp=n.next;
       n.data=temp.data;
       n.next=temp.next;
       temp=null;
    }
}
