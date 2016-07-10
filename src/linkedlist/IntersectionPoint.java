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
Write a function to get the intersection point of two Linked Lists.
There are two singly linked lists in a system. By some programming error the end node of one of the linked list got linked into the second list, forming a inverted Y shaped list. Write a program to get the point where two linked list merge.

Y ShapedLinked List
Above diagram shows an example with two linked list having 15 as intersection point.
Method 1(Simply use two loops)
Use 2 nested for loops. Outer loop will be for each node of the 1st list and inner loop will be for 2nd list. In the inner loop, check if any of nodes of 2nd list is same as the current node of first linked list. Time complexity of this method will be O(mn) where m and n are the number of nodes in two lists.

Method 2 (Mark Visited Nodes)
This solution requires modifications to basic linked list data structure. Have a visited flag with each node. Traverse the first linked list and keep marking visited nodes. Now traverse second linked list, If you see a visited node again then there is an intersection point, return the intersecting node. This solution works in O(m+n) but requires additional information with each node. A variation of this solution that doesn’t require modification to basic data structure can be implemented using hash. Traverse the first linked list and store the addresses of visited nodes in a hash. 
Now traverse the second linked list and if you see an address that already exists in hash then return the intersecting node.

Method 3(Using difference of node counts)
*******NOTE******IMPLEMENTED IN C FILENAME: IntersectionPoint.c
1) Get count of the nodes in first list, let count be c1.
2) Get count of the nodes in second list, let count be c2.
3) Get the difference of counts d = abs(c1 – c2)
4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
5) Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)

Method 4(Make circle in first list)
Thanks to Saravanan Man for providing below solution.
1. Traverse the first linked list(count the elements) and make a circular linked list. (Remember last node so that we can break the circle later on).
2. Now view the problem as find the loop in the second linked list. So the problem is solved.
3. Since we already know the length of the loop(size of first linked list) we can traverse those many number of nodes in second list, and then start another pointer from the beginning of second list. we have to traverse until they are equal, and that is the required intersection point.
4. remove the circle from the linked list.

Time Complexity: O(m+n)
Auxiliary Space: O(1)

Method 5 (Reverse the first list and make equations)
Thanks to Saravanan Mani for providing this method.

1) Let X be the length of the first linked list until intersection point.
   Let Y be the length of the second linked list until the intersection point.
   Let Z be the length of the linked list from intersection point to End of
   the linked list including the intersection node.
   We Have
           X + Z = C1;
           Y + Z = C2;
2) Reverse first linked list.
3) Traverse Second linked list. Let C3 be the length of second list - 1. 
     Now we have
        X + Y = C3
     We have 3 linear equations. By solving them, we get
       X = (C1 + C3 – C2)/2;
       Y = (C2 + C3 – C1)/2;
       Z = (C1 + C2 – C3)/2;
      WE GOT THE INTERSECTION POINT.
4)  Reverse first linked list.
Advantage: No Comparison of pointers.
Disadvantage : Modifying linked list(Reversing list).

Time complexity: O(m+n)
Auxiliary Space: O(1)

Method 6 (Traverse both lists and compare addresses of last nodes) This method is only to detect if there is an intersection point or not. (Thanks to NeoTheSaviour for suggesting this)

1) Traverse the list 1, store the last node address
2) Traverse the list 2, store the last node address.
3) If nodes stored in 1 and 2 are same then they are intersecting.
Time complexity of this method is O(m+n) and used Auxiliary space is O(1)

Method 7 (Use Hashing)
Basically we need to find common node of two linked lists. So we hash all nodes of first list and then check second list.
1) Create an empty hash table such that node address is used as key and a binary value present/absent is used as value.
2) Traverse the first linked list and insert all nodes’ addresses in hash table.
3) Traverse the second list. For every node check if it is present in hash table. If we find a node in hash table, return the node.

Asked in: Amazon DE Shaw Goldman Sachs Microsoft Zopper
*/
public class IntersectionPoint 
{
    public static int findIntersectionPoint(Linked_List l1,Linked_List l2)
    {
        HashSet<Node> list=new HashSet<>();
        Node n=l1.head;
        while(n!=null)
        {
            list.add(n);
            n=n.next;
        }
        n=l2.head;
        while(n!=null)
        {
            if(list.contains(n))
                return n.data;
            n=n.next;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Linked_List l1=new Linked_List();
        Linked_List l2=new Linked_List();
        l1.head=new  Node(10);
        l2.head=new Node(3);
        l2.head.next=new Node(6);
        l2.head.next.next=new Node(9);
        Node common=new Node(15);
        l2.head.next.next.next=common;
        l1.head.next=common;
        l1.head.next.next=new Node(30);
        l1.head.next.next.next=null;
        l1.printNodes();
        l2.printNodes();
        System.out.println(findIntersectionPoint(l1, l2));
    }
}
