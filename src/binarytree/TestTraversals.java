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
public class TestTraversals 
{
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        Node root=bt.root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        System.out.println("In-Order ");
        bt.inorder(root);
        System.out.println("\nPre-Order ");
        bt.preorder(root);
        System.out.println("\nPost-Order");
        bt.postorder(root);
    }
}
