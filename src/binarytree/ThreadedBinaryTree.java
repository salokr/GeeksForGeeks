/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author ashutosh
 */
/*
Threaded Binary Tree
Inorder traversal of a Binary tree is either be done using recursion or with the use of a auxiliary stack. 
The idea of threaded binary trees is to make inorder traversal faster and do it without stack and without recursion. 
A binary tree is made threaded by making all right child pointers that would normally be NULL point to the inorder successor of 
the node (if it exists).
There are two types of threaded binary trees.
Single Threaded: Where a NULL right pointers is made to point to the inorder successor (if successor exists)
Double Threaded: Where both left and right NULL pointers are made to point to inorder predecessor and inorder successor respectively.
The predecessor threads are useful for reverse inorder traversal and postorder traversal.
The threads are also useful for fast accessing ancestors of a node.
*/
public class ThreadedBinaryTree
{
 /*Don't know how to implement it yet, just adding code for inorder traversal, as in GEEKS website :p :p */  
    public static void doInorder(ThreadNode root)
    {
        ThreadNode current=leftMost(root);
        while(current!=null)
        {
            System.out.print(current.data+" ");
            if(current.rightthread)
                current=current.right;
            else current=leftMost(current.right);
        }
    }
    public static ThreadNode leftMost(ThreadNode current)
    {
        if(current==null)
            return current;
        while(current.left!=null)
            current=current.left;
        return current;
    }
    public static void main(String[] args)
    {
        ThreadNode six=new ThreadNode(6);
        ThreadNode three=new ThreadNode(3);
        ThreadNode one=new ThreadNode(1);
        ThreadNode five=new ThreadNode(5);
        ThreadNode eight=new ThreadNode(8);
        ThreadNode seven=new ThreadNode(7);
        ThreadNode eleven=new ThreadNode(11);
        ThreadNode nine=new ThreadNode(9);
        ThreadNode thirteen=new ThreadNode(13);
        six.left=three;six.right=eight;
        three.left=one;three.right=five;
        one.right=three;five.right=six;
        one.rightthread=five.rightthread=true;
        eight.left=seven;eight.right=eleven;
        seven.right=eight;seven.rightthread=true;
        eleven.left=nine;eleven.right=thirteen;
        nine.right=eleven;nine.rightthread=true;
        doInorder(six);
    }
}
class ThreadNode
{
    boolean rightthread;
    ThreadNode left,right;
    int data;
    public ThreadNode(int data)
    {
        this.data=data;
        rightthread=false;
    }
}