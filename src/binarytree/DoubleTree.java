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
public class DoubleTree 
{
    public static void convertToDoubleTree(Node current)
    {
        if(current==null)
            return;
        convertToDoubleTree(current.left);
        convertToDoubleTree(current.right);
        Node duplicate=new Node(current.data);
        duplicate.left=current.left;
        current.left=duplicate;
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        convertToDoubleTree(tree.root);
        PrintLevelOrderTraversalLineByLine.doLevelOrder(tree);
    }
}
