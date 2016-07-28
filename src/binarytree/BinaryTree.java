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
public class BinaryTree 
{
    Node root;
    /**
     * Preorder traversal is used to create a copy of the tree. 
     * Preorder traversal is also used to get prefix expression on of an expression tree.
     * Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.
     */
    public void preorder(Node current)
    {
        if(current==null)
            return;
        System.out.print(current+" ");
        preorder(current.left);
        preorder(current.right);
    }
    /**
     *Postorder traversal is used to delete the tree. 
     *Postorder traversal is also useful to get the postfix expression of an expression tree. 
     *Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression. 
     */
    public void postorder(Node current)
    {
        if(current==null)
            return;
        postorder(current.left);
        postorder(current.right);
        System.out.print(current+" ");
    }
    /**
     *Uses of Inorder in case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. 
     *To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder itraversal s reversed, can be used.
     */
    public void inorder(Node current)
    {
        if(current==null)
            return;
        inorder(current.left);
        System.out.print(current+" ");
        inorder(current.right);
    }
    void addFirst(int data)
    {
        Node newnode=new Node(data);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Node emptyparent=null;
        if(root==null)
        {
            root=newnode;
            return;
        }
        while(!q.isEmpty())
        {
            Node deq=q.remove();
            if(deq.left==null||deq.right==null)
            {
                emptyparent=deq;
                break;
            }
            if(deq.left!=null)
                q.add(deq.left);
            if(deq.right!=null)
                q.add(deq.right);
        }
        if(emptyparent.left==null)
            emptyparent.left=newnode;
        else emptyparent.right=newnode;
    }
    void addRandomN(int n)
    {
        for(int i=0;i<n;i++)
            addFirst((int)(Math.random()*100));
    }
    void addSortedN(int n)
    {
        for(int i=0;i<n;i++)
            addFirst(i+1);
    }
    int getHeight(Node current)
    {
        if(current==null||(current.left==null&&current.right==null))
            return 0;
        int lefth=getHeight(current.left);
        int righth=getHeight(current.right);
        int max=lefth>righth?lefth:righth;
        return max+1;
    }
}
class Node
{
    int data;
    Node left,right;
    public Node(int data)
    {
        this.data=data;
        left=right=null;
    }
    @Override
    public String toString()
    {
        return data+" ";
    }
}