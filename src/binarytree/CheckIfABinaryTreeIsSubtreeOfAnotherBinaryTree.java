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
public class CheckIfABinaryTreeIsSubtreeOfAnotherBinaryTree
{
    public static boolean isSubtree(Node curr1,Node curr2)
    {
        /*if both are null no need to check further*/
        if(curr1==null&&curr2==null)
            return true;
        /*if one of 'em is null, return false*/
        if(curr1==null||curr2==null)
            return false;
        boolean result=false;
        if(curr1.data==curr2.data)
        {
            result=remainingIdentical(curr1, curr2);
        }
        return result||remainingIdentical(curr1.left, curr2)||remainingIdentical(curr1.right, curr2);
    }
    public static boolean remainingIdentical(Node n1,Node n2)
    {
        if(n1==null&&n2==null)
            return true;
        if(n1==null||n2==null)
            return false;
        return n1.data==n2.data&&remainingIdentical(n1.left, n2.left)&&remainingIdentical(n1.right, n2.right);
    }
    public static void main(String[] args)
    {
        BinaryTree tree1 = new BinaryTree();
          
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
           
        tree1.root = new Node(26);
        tree1.root.right = new Node(3);
        tree1.root.right.right = new Node(3);
        tree1.root.left = new Node(10);
        tree1.root.left.left = new Node(4);
        tree1.root.left.left.right = new Node(30);
        tree1.root.left.right = new Node(6);
  
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
        BinaryTree tree2 = new BinaryTree();   
        tree2.root = new Node(10);
        tree2.root.right = new Node(6);
        tree2.root.left = new Node(4);
        tree2.root.left.right = new Node(30);
  
        if (isSubtree(tree1.root, tree2.root))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }
}
/*
Check if a binary tree is subtree of another binary tree | Set 1
Given two binary trees, check if the first tree is subtree of the second one.
A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.
The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.
For example, in the following case, tree S is a subtree of tree T.

        Tree 2
          10  
        /    \ 
      4       6
       \
        30


        Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30
*/