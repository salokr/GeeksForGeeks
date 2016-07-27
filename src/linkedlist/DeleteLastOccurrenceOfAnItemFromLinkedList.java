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
Delete last occurrence of an item from linked list
Given a liked list and a key to be deleted. Delete last occurrence of key from linked. 
The list may have duplicates.
Examples:
Input:   1->2->3->5->2->10, key = 2
Output:  1->2->3->5->10 
*/
public class DeleteLastOccurrenceOfAnItemFromLinkedList 
{
    public static void deleteLast(Linked_List ll,int key)
    {
        Node temp=ll.head,todelete=ll.head,parentofkey=null,parent=null;
        while(temp!=null)
        {
            if(temp.data==key)
            {
                parentofkey=parent;
                todelete=temp;
            }
            parent=temp;
            temp=temp.next;
        }
        if(todelete==null)
            return;
        if(parentofkey==null)//To delete head of the linked list 
        {
            ll.head=ll.head.next;
            return;
        }
        parentofkey.next=todelete.next;
        //ll.printNodes();
    }
    public static void main(String[] args)
    {
        //1,2,3,5,2,10
        Linked_List ll=new Linked_List();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(5);
        head.next.next.next.next=new Node(2);
        head.next.next.next.next.next=new Node(10);
        ll.head=head;
        deleteLast(ll,10);
        ll.printNodes();
    }
}
