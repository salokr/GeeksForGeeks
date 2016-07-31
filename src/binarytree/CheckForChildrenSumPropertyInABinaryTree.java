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
Check for Children Sum Property in a Binary Tree
Given a binary tree, write a function that returns true if the 
tree satisfies below property.
For every node, data value must be equal to sum of data values in left and right children. 
Consider data value as 0 for NULL children. Below tree is an example
*/
public class CheckForChildrenSumPropertyInABinaryTree 
{
    public static boolean checkProperty(Node current)
    {
        if(current==null||(current.left==null&&current.right==null))
            return true;
        int childsum=current.left==null?0:current.left.data + (current.right==null?0:current.right.data);
        return (current.data==childsum)&&checkProperty(current.left)&&checkProperty(current.right);
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.addSortedN(10);
        System.out.println(checkProperty(bt.root));
        bt=new BinaryTree();
        bt.addFirst(10);
        bt.addFirst(8);
        bt.addFirst(2);
        bt.addFirst(8);//bt.addFirst(4);
        bt.inorder(bt.root);
        System.out.println();
        System.out.println(checkProperty(bt.root));
    }
}
