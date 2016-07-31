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
Program to count leaf nodes in a binary tree
A node is a leaf node if both left and right child nodes of it are NULL.
*/
public class ProgramToCountLeafNodesInABinaryTree
{
    public static int getCount(Node current)
    {
        if(current==null)
            return 0;
        if(current.left==null&&current.right==null)
            return 1;
        int left=getCount(current.left);
        int right=getCount(current.right);
        return left+right;
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.addRandomN(10);
        System.out.println(getCount(bt.root));
    }
}
