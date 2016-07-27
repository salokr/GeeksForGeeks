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
Compare two linked lists
linked list  
Given two string, represented as linked lists (every character is a node in linked list). 
Write a function compare() that works similar to strcmp(), i.e., it returns 0 if both strings are same,
1 if first linked list is lexicographically greater, and -1 if second is lexicographically greater.
Input:
In this problem, method takes two argument: the head of the first and second linked list. 
The function should not read any input from stdin/console.
The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list. 
There are multiple test cases. For each test case, this method will be called individually.
Output:
Comapare two strings represented as linked list.
*/

public class CompareTwoLinkedLists
{
    public static int compare(Node node1,Node node2)
    {
        while(node1!=null&&node2!=null)
        {
            if(node1.data!=node2.data)
            {
                if(node1.data>node2.data)
                    return 1;
                else return -1;
            }
            node1=node1.next;
            node2=node2.next;
        }
        if(node1==null&&node2!=null)
            return -1;
        if(node2==null&&node1!=null)
            return 1;
        return 0;
    }
}
