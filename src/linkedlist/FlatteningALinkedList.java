/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.LinkedList;

/**
 *
 * @author ashutosh
 */
/*
Flattening a Linked List
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted. For example, 
for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
*/

public class FlatteningALinkedList 
{
    
    public static void flattenList(MultiNode head)
    {
        
           
    }
    public static void main(String[] args)
    {
        LinkedList<MultiNode> ll=new LinkedList<>();
        Linked_List l1=new Linked_List();l1.addRandomN(3);
        Linked_List l2=new Linked_List();l2.addRandomN(1);
        Linked_List l3=new Linked_List();l3.addRandomN(2);
        Linked_List l4=new Linked_List();l4.addRandomN(3);
        MultiNode mn1=new MultiNode(5, l1.head);
        MultiNode mn2=new MultiNode(10, l2.head);
        MultiNode mn3=new MultiNode(19, l3.head);
        MultiNode mn4=new MultiNode(28, l4.head);
        ll.add(mn1);ll.add(mn2);ll.add(mn3);ll.add(mn4);
        flattenList(ll.peekFirst());
    }
}
class MultiNode extends Node
{
    Node down;
    public MultiNode(int data,Node down)
    {
        super(data);
        this.down=down;
    }
}