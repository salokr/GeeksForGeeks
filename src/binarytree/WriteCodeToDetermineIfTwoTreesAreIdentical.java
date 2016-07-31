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
public class WriteCodeToDetermineIfTwoTreesAreIdentical
{
    public static boolean areIdentical(Node root1,Node root2)
    {
        /*if both empty no need to check further*/
        if(root1==null&&root2==null)
            return true;
        /*if both non-empty verify further*/
        if(root1!=null&&root2!=null)
            return (root1.data==root2.data&&areIdentical(root1.left,root2.left)&&areIdentical(root2.right,root1.right));
        /*otherwise one is empty other is not*/
        return false;
    }
    public static void main(String[] args)throws Exception
    {
        BinaryTree bt1=new BinaryTree();
        BinaryTree bt2=new BinaryTree();
        bt1.addRandomN(10);bt2.addRandomN(10);
        System.out.println(areIdentical(bt1.root, bt2.root));
        BinaryTree clone=(BinaryTree)bt1.clone();
        Node cloneroot=clone.root;
        System.out.println(areIdentical(cloneroot,bt1.root));
    }
}
