/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.LinkedList;

/**
 *
 * @author ashutosh
 */
public class ConnectNodesAtSameLevelUsingConstantExtraSpace
{
    public static ExtendedNode getNextRight(ExtendedNode parent)
    {
        ExtendedNode right=parent.nextRight;
        while(right!=null)
        {
            if(right.left!=null)
                return right.left;
            if(right.right!=null)
                return right.right;
            right=right.nextRight;
        }
        return null;
    }
    /*function to set childs rightpointers*/
    public static void connectRecursively(ExtendedNode current)
    {
        if(current==null)
            return;
        if(current.nextRight!=null)
            connectRecursively(current.nextRight);
        if(current.left!=null)
        {
            if(current.right!=null)
            {
                current.left.nextRight=current.right;
                current.right.nextRight=getNextRight(current);
            }
            else
                current.left.nextRight=getNextRight(current);
            connectRecursively(current.left);
        }
        else if(current.right!=null)
        {
            current.right.nextRight=getNextRight(current);
            connectRecursively(current.right);
        }
        else
            connectRecursively(getNextRight(current));
    }
    /*Idea for iterative*/
    public static void connectConstantSpace(ExtendedNode root)
    {
        connectRecursively(root);
    }
    public static void main(String[] args)
    {
        ExtendedNode root= new ExtendedNode(10);
        root.left = new ExtendedNode(8);
        root.right = new ExtendedNode(2);
        root.left.left = new ExtendedNode(3);
        root.right.right = new ExtendedNode(90);
        connectConstantSpace(root);
        int a = root.nextRight != null ? 
                                     root.nextRight.data : -1;
        int b = root.left.nextRight != null ? 
                                 root.left.nextRight.data : -1;
        int c = root.right.nextRight != null ? 
                                root.right.nextRight.data : -1;
        int d = root.left.left.nextRight != null ? 
                                  root.left.left.nextRight.data : -1;
          
        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + root.data + " is " + a);
        System.out.println("nextRight of " + root.left.data 
                                                       + " is " + b);
        System.out.println("nextRight of " + root.right.data + 
                                                           " is " + c);
        System.out.println("nextRight of " + root.left.left.data + 
                                                            " is " + d);
       
    }
}
class ExtendedNode
{
    
    ExtendedNode nextRight,left,right;
    int data;
    ExtendedNode(int item) 
    {
        data=item;
        left=right=nextRight = null;
    }
}
  