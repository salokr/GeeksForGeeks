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
public class ConvertAnArbitraryBinaryTreeToATreeThatHoldsChildrenSumProperty
{
    public static void convertTree(Node current)
    {
        if(current==null||(current.left==null&&current.right==null))
            return;
        convertTree(current.left);
        convertTree(current.right);
        int leftval=current.left==null?0:current.left.data;
        int rightval=current.right==null?0:current.right.data;
        int sum=leftval+rightval;
        int diff=sum-current.data;/*if diff is -ve, then childs has lesser value,increement one of child's value and then call recursively to adjust its childs value
        else adjust current node's value and continue*/
        if(diff==0)
            return;
        else if(diff<0)
        {
            /*find one of childs, increement them and call recursively to adjust subtree rooted at them*/
            if(current.left!=null)
            {
                current.left.data+=Math.abs(diff);
                convertTree(current.left);
            }
            else
            {
                current.right.data+=Math.abs(diff);
                convertTree(current.right);
            }
        }
        else
        {
            /*difference is positive, adjust current only*/
            current.data+=diff;
        }
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.root=new Node(50);bt.addFirst(7);bt.addFirst(2);bt.addFirst(3);bt.addFirst(5);bt.addFirst(1);bt.addFirst(30);
        PrintLevelOrderTraversalLineByLine.doLevelOrder(bt);
        convertTree(bt.root);
        System.out.println("\n");
        PrintLevelOrderTraversalLineByLine.doLevelOrder(bt);
        System.out.println("\n");
        
        bt=new BinaryTree();
        bt.root=new Node(5);
        bt.root.left=new Node(4);
        bt.root.left.left=new Node(3);
        bt.root.left.left.left=new Node(2);
        bt.root.left.left.left.right=new Node(1);
        PrintLevelOrderTraversalLineByLine.doLevelOrder(bt);
        convertTree(bt.root);
        System.out.println("\n");
        PrintLevelOrderTraversalLineByLine.doLevelOrder(bt);
    }
}
