package binarytree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 */
public class PrintNodesAtKDistanceFromRoot
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
         
        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8 
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);
  
        printKDistant(tree.root, 2);
    }

    private static void printKDistant(Node root, int i) 
    {
        if(root==null)
            return;
        if(i==0)
        {
            System.out.print(root+" ");
            return;
        }
        printKDistant(root.left, i-1);
        printKDistant(root.right, i-1);
    }
}
