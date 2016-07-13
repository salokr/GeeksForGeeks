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
Construct a Maximum Sum Linked List out of two Sorted Linked Lists having some Common nodes
Given two sorted linked lists, construct a linked list that contains maximum sum path from start to end. 
The result list may contain nodes from both input lists. When constructing the result list, we may switch to the other input
list only at the point of intersection (which mean the two node with the same value in the lists). You are allowed to use O(1) extra space.
Input:
List1 =  1->3->30->90->120->240->511
List2 =  0->3->12->32->90->125->240->249
Output: Following is maximum sum linked list out of two input lists
list =  1->3->12->32->90->125->240->511
we switch at 3 and 240 to get above maximum sum linked list
*/
public class ConstructAMaximumSumLinkedListOutOfTwoSortedLinkedListsHavingSomeCommonNodes
{
    public static Node maxSumLinkedList(Linked_List l1,Linked_List l2)
    {
        if(l1.head==null)
            return l2.head;
        if(l2.head==null)
            return l1.head;
        Node start1=l1.head,start2=l2.head,prev1,prev2,result=null,resultend=null;
        while(start1!=null||start2!=null)
        {
            prev1=start1;prev2=start2;
            int sum1=0,sum2=0;
            while(start1!=null&&start2!=null&&start1.data!=start2.data)
            {
                if(start1.data<start2.data)
                {
                    sum1+=start1.data;
                    start1=start1.next;
                }
                else //if(start1.data>start2.data)
                {
                    sum2+=start2.data;
                    start2=start2.next;
                }
            }
            if(start1==null)
                while(start2!=null)
                {
                    sum2+=start2.data;
                    start2=start2.next; 
                }
            if(start2==null)
                while(start1!=null)
                {
                    sum1+=start1.data;
                    start1=start1.next; 
                }
            
            if(sum1>sum2)
            {
                if(result==null)
                    result=prev1;
                else
                    resultend.next=prev1;
                resultend=start1;
            }
            else
            {
                if(result==null)
                    result=prev2;
                else
                    resultend.next=prev2;
                resultend=start2;
            }
            if(start1!=null)
                start1=start1.next;
            if(start2!=null)
                start2=start2.next;
        }
        return result;
    }
    public static void main(String[] args)
    {
        Linked_List l1=new Linked_List();
        Linked_List l2=new Linked_List();
        l1.addAtEnd(1);l1.addAtEnd(3);l1.addAtEnd(30);l1.addAtEnd(90);l1.addAtEnd(120);l1.addAtEnd(240);l1.addAtEnd(511);
        l2.addAtEnd(0);l2.addAtEnd(3);l2.addAtEnd(12);l2.addAtEnd(32);l2.addAtEnd(90);l2.addAtEnd(125);l2.addAtEnd(240);l2.addAtEnd(249);
        Util.printFromNode(maxSumLinkedList(l1, l2));
        
        Linked_List l3=new Linked_List();
        Linked_List l4=new Linked_List();
        l3.addAtEnd(1);l3.addAtEnd(3);l3.addAtEnd(30);l3.addAtEnd(90);l3.addAtEnd(110);l3.addAtEnd(120);
        l4.addAtEnd(0);l4.addAtEnd(3);l4.addAtEnd(12);l4.addAtEnd(32);l4.addAtEnd(90);l4.addAtEnd(100);l4.addAtEnd(120);l4.addAtEnd(130);
        Util.printFromNode(maxSumLinkedList(l3, l4));
    }
    
}
