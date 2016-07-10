/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.HashSet;

/**
 *
 * @author ashutosh
 */
/*
Remove duplicates from an unsorted linked list
Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. 
The list is not sorted.

For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43.

METHOD 1 (Using two loops)
This is the simple way where two loops are used. Outer loop is used to pick the elements one by one and inner loop 
compares the picked element with rest of the elements.
*/
public class RemoveDuplicatesFromAnUnsortedLinkedList
{
    public static void removeDuplicates(Linked_List ll)
    {
        HashSet<Integer> present=new HashSet<>();
        Node start=ll.head,parent=null;
        while(start!=null)
        {
            if(present.contains(start.data))
                parent.next=start.next;
            else
            {
                present.add(start.data);
                parent=start;
            }
            start=start.next;
        }
        ll.printNodes();
    }
    public static void main(String args[])
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(20,10);
        removeDuplicates(ll);
    }
}
