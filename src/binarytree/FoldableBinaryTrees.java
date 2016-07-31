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
public class FoldableBinaryTrees 
{
    public static void main(String args[]) 
    {
        BinaryTree tree = new BinaryTree();
         
        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        if (isFoldable(tree.root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
        
        tree.root.left.right.left=new Node(1);
        if (isFoldable(tree.root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
    }

    private static boolean isFoldable(Node root)
    {
        if(root==null)
            return true;
        return areMirror(root.left,root.right);
    }
    private static boolean areMirror(Node left,Node right)
    {
        /*if both are null*/
        if(left==null&&right==null)
            return true;
        /*if reached here then atleast one isn't null*/
        if(left==null||right==null)
            return false;
        return areMirror(left.left,right.right)&&areMirror(right.left,left.right);
    }
}
