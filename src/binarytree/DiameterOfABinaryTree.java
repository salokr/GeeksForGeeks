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
Diameter of a Binary Tree
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. 
The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded 
(note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
The diameter of a tree T is the largest of the following quantities:
http://stackoverflow.com/questions/11897088/diameter-of-binary-tree-better-design
* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
*/
public class DiameterOfABinaryTree
{
    public static int getHeight(Node root) {
    if (root == null)
        return 0;

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}
    public static int getDiameter2(Node current)
    {
        if(current==null)
            return 0;
        int leftd=getDiameter(current.left);
        int rightd=getDiameter(current.right);
        int rootd=getHeight(current.left)+getHeight(current.right)+1;
        return Math.max(leftd,Math.max(rightd,rootd));
    }
    //optimized version
    public static int getDiameter(Node current)
    {
        /*if(current==null)
            return 0;
        int leftd=getDiameter(current.left);
        int rightd=getDiameter(current.right);*/
        return 0;
        
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.root = new Node(1);
        bt.root.left       = new Node(2);
        bt.root.right      = new Node(3);
        bt.root.left.left  = new Node(4);
        bt.root.left.left.left  = new Node('*');
        bt.root.left.right = new Node(5);
        System.out.println(getDiameter(bt.root));
        System.out.println(getDiameter2(bt.root));
    }
}
