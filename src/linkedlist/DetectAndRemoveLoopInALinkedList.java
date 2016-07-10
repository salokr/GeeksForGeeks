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
Detect and Remove Loop in a Linked List
Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and if loop is present then removes the loop and returns true. And if the list doesn’t contain loop then returns false. Below diagram shows a linked list with a loop. detectAndRemoveLoop() must change the below list to 1.2.3.4.5.NULL.



We recommend to read following post as a prerequisite.

Write a C function to detect loop in a linked list

Before trying to remove the loop, we must detect it. Techniques discussed in the above post can be used to detect loop. To remove loop, all we need to do is to get pointer to the last node of the loop. For example, node with value 5 in the above diagram. Once we have pointer to the last node, we can make the next of this node as NULL and loop is gone.
We can easily use Hashing or Visited node techniques (discussed in the above mentioned post) to get the pointer to the last node. Idea is simple: the very first node whose next is already visited (or hashed) is the last node.
We can also use Floyd Cycle Detection algorithm to detect and remove the loop. In the Floyd’s algo, the slow and fast pointers meet at a loop node. We can use this loop node to remove cycle. There are following two different ways of removing loop when Floyd’s algorithm is used for Loop detection.

Method 1 (Check one by one) 
We know that Floyd’s Cycle detection algorithm terminates when fast and slow pointers meet at a common point. 
We also know that this common point is one of the loop nodes (2 or 3 or 4 or 5 in the above diagram). 
We store the address of this in a pointer variable say ptr2. Then we start from the head of the Linked List and check for nodes one by one
if they are reachable from ptr2. When we find a node that is reachable,
we know that this node is the starting node of the loop in Linked List and we can get pointer to the previous of this node.

Method 2 (Better Solution)
This method is also dependent on Floyd’s Cycle detection algorithm.
1) Detect Loop using Floyd’s Cycle detection algo and get the pointer to a loop node.
2) Count the number of nodes in loop. Let the count be k.
3) Fix one pointer to the head and another to kth node from head.
4) Move both pointers at the same pace, they will meet at loop starting node.
5) Get pointer to the last node of loop and make next of it as NULL.

Method 3 (Optimized Method 2: Without Counting Nodes in Loop)
We do not need to count number of nodes in Loop. 
After detecting the loop, if we start slow pointer from head and move both slow 
and fast pointers at same speed until fast don’t meet, they would meet at the beginning of linked list.
How does this work?
Distance traveled by fast pointer = 2 * (Distance traveled 
                                         by slow pointer)

(m + n*x + k) = 2*(m + n*y + k)

Note that before meeting the point shown above, fast
was moving at twice speed.

x -.  Number of complete cyclic rounds made by 
       fast pointer before they meet first time

y -.  Number of complete cyclic rounds made by 
       slow pointer before they meet first time

From above equation, we can conclude below

    m + k = (x-2y)*n

Which means m+k is a multiple of n. 
So if we start moving both pointers again at same speed such that one pointer (say slow) begins 
from head node of linked list and other pointer (say fast) begins from meeting point. 
When slow pointer reaches beginning of linked list (has made m steps). Fast pointer would have made also 
moved m steps as they are now moving same pace. Since m+k is a multiple of n and fast starts from k, they would meet at the beginning. 
Can they meet before also? No because slow pointer enters the cycle first time after m steps.
*/
public class DetectAndRemoveLoopInALinkedList
{
    public static Node getLoopNode(Node head)
    {
        Node slow=head,fast=head,loopnode=null;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                loopnode=slow;
                break;
            }
        }
        return loopnode;
    }
    public static void detectAndBreakLoop(Linked_List ll)
    {
        Node loopnode=getLoopNode(ll.head);
        //System.out.println(loopnode.data);
        if(loopnode==null)
            return;
        Node start=ll.head;
        while(loopnode.next!=start.next)
        {
            loopnode=loopnode.next;
            start=start.next;
        }
        loopnode.next=null;
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        Node head=ll.head=new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(20);
        /* Create a loop for testing */
        head.next.next.next.next.next.next = head.next.next;
        detectAndBreakLoop(ll);
        ll.printNodes();
    }
}
