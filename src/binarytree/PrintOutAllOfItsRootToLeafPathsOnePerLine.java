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
public class PrintOutAllOfItsRootToLeafPathsOnePerLine
{
    /*
    if don't want to use String take a character Array modify it as you go, and print it once you reach the leaf node. 
    */
    public static void printPaths(Node current,String path)
    {
        if(current==null)
        {
            System.out.println(path);
            return; 
        }
        path+=current.data+" ";
        if(current.left==null&&current.right==null)
        {
            System.out.println(path);
            return;
        }
        printPaths(current.left, path);
        printPaths(current.right, path);
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.addRandomN(10);
        printPaths(bt.root,"");
    }
}
