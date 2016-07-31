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
Write a program to Calculate Size of a tree
Size of a tree is the number of elements present in the tree. 
*/
public class WriteAProgramToCalculateSizeOfATree
{
    public static int getSize(Node current)
    {
        if(current==null)
            return 0;
        int leftcount=getSize(current.left);
        int rightcount=getSize(current.right);
        return 1+(leftcount+rightcount);
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.addRandomN(100);
        System.out.println(getSize(bt.root));
    }
}
