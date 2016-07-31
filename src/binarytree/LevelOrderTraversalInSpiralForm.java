/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.Stack;

/**
 *
 * @author ashutosh
 */
public class LevelOrderTraversalInSpiralForm
{
    public static void doLevelOrderSpiral(Node root)
    {
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()||!s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                Node tos=s1.pop();
                System.out.print(tos.data+" ");
                if(tos.right!=null)
                    s2.push(tos.right);
                if(tos.left!=null)
                    s2.push(tos.left);
            }
            while(!s2.isEmpty())
            {
                Node tos=s2.pop();
                System.out.print(tos.data+" ");
                if(tos.left!=null)
                    s1.push(tos.left);
                if(tos.right!=null)
                    s1.push(tos.right);
            }
        }
    }
    public static void main(String[] afgs)
    {
        BinaryTree bt=new BinaryTree();
        bt.addSortedN(7);
        doLevelOrderSpiral(bt.root);
    }
}
