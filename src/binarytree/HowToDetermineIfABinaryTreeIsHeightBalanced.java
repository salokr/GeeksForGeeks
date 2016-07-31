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
How to determine if a binary tree is height-balanced?
A tree where no leaf is much farther away from the root than any other leaf. Different 
balancing schemes allow different definitions of “much farther” and different amounts of work to keep them balanced.
Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.

The above height-balancing scheme is used in AVL trees.
*/
public class HowToDetermineIfABinaryTreeIsHeightBalanced
{
    //one approach could be to separately calculate left and right heights everytime and then  check the required condition, this will take O(n^2) time
    //another idea is to calculate heights during recursion and then proceed above
    public static boolean isBalanced(Node root,Height h)
    {
        if(root==null)
        {
            h.height=0;
            return true;
        }
        Height lefth=new Height(),righth=new Height();
        lefth.height++;righth.height++;//counting self,Height here is defined as max number of NODES from current to left
        boolean isleftbalanced=isBalanced(root.left,lefth);
        boolean isrighttbalanced=isBalanced(root.right,righth);
        h.height=Math.max(lefth.height,righth.height)+1;
        //System.out.println(h+" "+"->"+Math.abs(lefth.height-righth.height)+" "+lefth+" "+righth+" "+ root+"<-DATA ");
        return isleftbalanced&&isrighttbalanced&&(Math.abs(lefth.height-righth.height)<2);
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(isBalanced(tree.root,new Height()));
        
        
        
        tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.left.left = new Node(7);
        tree.root.left.left.left.left.left = new Node(7);
        tree.root.left.left.left.left.left.left = new Node(7);
        tree.root.left.left.left.left.left.left.left = new Node(7);
        tree.root.left.left.left.left.left.left.left.left = new Node(7);
        tree.root.left.left.left.left.left.left.left.left.left = new Node(7);
        System.out.println(isBalanced(tree.root,new Height()));
    }
}
class Height
{
    int height;
    public Height()
    {
        height=0;
    }
    public Height(int h)
    {
        height=h;
    }
    public String toString(){return height+"";}
}