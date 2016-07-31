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
Write an Efficient Function to Convert a Binary Tree into its Mirror Tree
Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
*/
public class WriteAnEfficientFunctionToConvertABinaryTreeIntoItsMirrorTree 
{
    public static void getMirrorImage(Node current)
    {
        if(current==null)
            return;
        Node temp=current.left;
        current.left=current.right;
        current.right=temp;
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.addRandomN(5);
        getMirrorImage(bt.root);
        bt.inorder(bt.root);
    }
}
