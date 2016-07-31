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
Print Ancestors of a given node in Binary Tree
Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.

For example, if the given tree is following Binary Tree and key is 7, then your function should print 4, 2 and 1.


              1
            /   \
          2      3
        /  \
      4     5
     /
    7

*/
public class PrintAncestorsOfAGivenNodeInBinaryTree
{
    public static boolean printAncestors(Node current,int key)
    {
        if(current==null)
            return false;
        if(current.data==key)
            return true;
        boolean left=printAncestors(current.left, key);
        boolean right=printAncestors(current.right, key);
        boolean result=left||right;
        if(result)
            System.out.print(current.data+" ");
        return result;
    }
    public static void main(String[] args)
    {
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        printAncestors(tree.root,50);
        
    }
}
