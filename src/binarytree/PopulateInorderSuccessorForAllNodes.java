/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ashutosh
 */
/*
Populate Inorder Successor for all nodes
Given a Binary Tree where each node has following structure, 
write a function to populate next pointer for all nodes. The next pointer for every node should be set to point to inorder successor.
struct node
{
  int data;
  struct node* left;
  struct node* right;
  struct node* next;
}
*/

public class PopulateInorderSuccessorForAllNodes
{
    static MyNode prev,head;
    public static void connect(MyNode current)
    {
        if(current==null)
            return;
        connect(current.left);
        if(prev==null)
            head=current;
        else
            prev.next=current;
        prev=current;
        connect(current.right);
    }
    public static void doLevelOrder(MyNode root)
    {
        Queue<MyNode> q=new LinkedList<>();
        if(root==null)
            return;
        q.add(root);
        int size=q.size(),current=0;
        while(!q.isEmpty())
        {
            if(current==size)
            {
                current=0;
                size=q.size();
                System.out.println();
            }
            current++;
            MyNode deq=q.remove();
            System.out.print(deq.data+" ");
            if(deq.left!=null)q.add(deq.left);
            if(deq.right!=null)q.add(deq.right);
        }
    }
    
    
    public static void main(String[] args)
    {
        MyNode root=new MyNode(1);
        root.left=new MyNode(2);
        root.right=new MyNode(3);
        root.left.left=new MyNode(4);root.left.right=new MyNode(5);
        root.left.left.left=new MyNode(8);root.left.left.right=new MyNode(9);
        root.left.right=new MyNode(5);root.left.right.right=new MyNode(10);
        root.right.left=new MyNode(6);root.right.right=new MyNode(7);
        doLevelOrder(root);
        connect(root);
        System.out.println();
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
class MyNode
{
    int data;
    MyNode left,right,next;
    public MyNode(int data){this.data=data;left=right=next=null;}
}
