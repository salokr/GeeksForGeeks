/*
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
 */
package linkedlist;

import java.util.LinkedList;

/*
 *
 *@author ashutosh
*/
/*
Flattening a Linked List
Given a linked list where every Node represents a linked list and contains two pointers of its type:
(i) Pointer to next Node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this Node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 . 10 . 19 . 28
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
for the above input list, output list should be 5.7.8.10.19.20.22.28.30.35.40.45.50.
*/

public class FlatteningALinkedList 
{
    public static void mergeO(MultiNode list1,MultiNode list2,MultiNode root)
    {
        MultiNode start1=list1,start2=list2,temp=null,head=null;
        if(start1==null)
        {
            root= start2;
            return;
        }
        if(start2==null)
        {
            root= start1;
            return;
        }
        while(true)
        {
            if(start1.data<start2.data)
            {
                if(temp!=null)
                {
                    temp.down=start1;
                    temp=temp.down;
                }
                else
                    head=temp=start1;
                start1=start1.down;
            }
            else 
            {
                if(temp!=null)
                {
                    temp.down=start2;
                    temp=temp.down;
                }
                else
                    head=temp=start2;
                start2=start2.down;
            }
            if(start1==null)
            {
                temp.down=start2;
                break;
            }
            if(start2==null)
            {
                temp.down=start1;
                break;
            }
        }
        //printList(head);
        root=head;
    }
   
    public static MultiNode flattenList(MultiNode root)
    {
        if(root.next==null)
            return root;
        MultiNode tomerge=flattenList(root.next);
        mergeO(root,tomerge,root);
        //printList(root);
        return root;
    }
    public static void printList(MultiNode node)
    {
        while(node!=null)
        {
            System.out.print(node.data+" ");
            node=node.down;
        }
        System.out.println();
    }
    
static MultiNode merge(MultiNode list1,MultiNode list2)
{
    if(list1==null)
		return list2;
	if(list2==null)
		return list1;
	MultiNode list=null;
	if(list1.data<list2.data)
	{
		list=list1;
		list.down=merge(list1.down,list2);
	}
	else
	{
		list=list2;
		list.down=merge(list1,list2.down);
	}
        //printList(list);
	return list;
}
static MultiNode flatten(MultiNode root)
{
	if(root==null||root.next==null)
		return root;
	return merge(root,flatten(root.next));
}
    public static void main(String[] args)
    {
        MultiNode mn1=new MultiNode(5);
        MultiNode mn2=new MultiNode(10);
        MultiNode mn3=new MultiNode(19);
        //MultiNode mn4=new MultiNode(28);
        mn1.next=mn2;mn2.next=mn3;
        mn1.down=new MultiNode(7);
        mn1.down.down=new MultiNode(8);
        mn1.down.down.down=new MultiNode(30);
        mn2.down=new MultiNode(20);
        mn3.down=new MultiNode(22);
        mn3.down.down=new MultiNode(50);
        printList(flattenList(mn1));
        
    }
}
class MultiNode
{
    int data;
    MultiNode down,next;
    public MultiNode(int data)
    {
        this.data=data;
        next=down=null;
    }
}