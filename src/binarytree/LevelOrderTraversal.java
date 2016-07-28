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
public class LevelOrderTraversal
{
    //using two functions
    public static void doLevelOrder(BinaryTree bt)
    {
        Node root=bt.root;
        int height=bt.getHeight(root);
        //System.out.println(height);
        for(int i=0;i<=height;i++)
        {
            printLevel(root,i);
        }
    }
    public static void printLevel(Node current,int level)
    {
        if(current==null)
            return;
        if(level==0)
        {
            System.out.print(current.data+" ");
        }
        else
        {
            printLevel(current.left,level-1);
            printLevel(current.right,level-1);
        }
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.addSortedN(10);
        bt.inorder(bt.root);
        System.out.println();
        doLevelOrder(bt);
    }
}
