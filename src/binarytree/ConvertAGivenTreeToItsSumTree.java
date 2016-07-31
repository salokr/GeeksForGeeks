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
Convert a given tree to its Sum Tree
Given a Binary Tree where each node has positive and negative values. 
Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. 
The values of leaf nodes are changed to 0.
For example, the following tree

                  10
               /      \
	     -2        6
           /   \      /  \ 
	 8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
	   4(8-4)      12(7+5)
           /   \      /  \ 
	 0      0    0    0
*/
public class ConvertAGivenTreeToItsSumTree 
{
    public static void convertToSumTree(Node node,Sum s)
    {
        if(node==null)
        {
            s.sum=0;
            return;
        }
        int currentvalue=node.data;
        Sum lefts=new Sum();
        Sum rights=new Sum();
        convertToSumTree(node.left, lefts);
        convertToSumTree(node.right, rights);
        if(node.left==null&&node.right==null)
        {
            node.data=0;
        }
        node.data=lefts.sum+rights.sum;
        s.sum=node.data+currentvalue;
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
  
        /* Constructing tree given in the above figure */
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
  
        convertToSumTree(tree.root, new Sum());
  
        // Print inorder traversal of the converted tree to test result 
        // of toSumTree()
        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.inorder(tree.root);
    }
}