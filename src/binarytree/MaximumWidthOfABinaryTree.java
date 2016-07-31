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
public class MaximumWidthOfABinaryTree
{
    public static void maxWidth(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int size=q.size(),currsize=0,maxwidth=size;
        while(!q.isEmpty())
        {
            if(currsize==size)
            {
                size=q.size();
                if(size>maxwidth)
                    maxwidth=size;
                currsize=0;
            }
            currsize++;
            Node current=q.remove();
            if(current.left!=null)
                q.add(current.left);
            if(current.right!=null)
                q.add(current.right);
        }
        System.out.println(maxwidth);
    }
    public static void main(String[] args)
    {
         BinaryTree tree = new BinaryTree();
         
        /*
        Constructed bunary tree is:
              1
            /  \
           2    3
         /  \    \
        4   5     8 
                 /  \
                6   7
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
        maxWidth(tree.root);
    }
}
