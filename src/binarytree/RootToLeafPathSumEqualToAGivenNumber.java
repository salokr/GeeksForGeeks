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
public class RootToLeafPathSumEqualToAGivenNumber
{
   public static boolean hasPathSum(Node root, int sum)
    {
        if(sum==0)
            return true;
        if(root==null)
            return false;
        return hasPathSum(root.left,sum-root.data)||hasPathSum(root.right, sum-root.data);
    }
    public static void main(String args[]) 
    {
        int sum = 21;
         
        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
  
        if (hasPathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
        
        sum=14;
        if (hasPathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
        
        sum=9;
        if (hasPathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }
}
