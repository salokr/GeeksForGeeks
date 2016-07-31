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
public class FindTheMaximumSumLeafToRootPathInABinaryTree
{
    public static int getMaxSum(Node root,int currentsum)
    {
        if(root==null)
        {
            return currentsum;
        }
        int leftmax=getMaxSum(root.left, root.data+currentsum);
        int rightmax=getMaxSum(root.right,root.data+ currentsum);
        return Math.max(rightmax,leftmax);
    }
    public static void getMaxSumPath(Node root,int currsum,int requiredsum,String path)
    {
        if(root==null)
        {
            if(currsum==requiredsum)
                System.out.println(path);
            return;
        }
        getMaxSumPath(root.left, currsum+root.data, requiredsum, path+" "+root.data);
        getMaxSumPath(root.right, currsum+root.data, requiredsum, path+" "+root.data);
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        System.out.println("Following are the nodes "+
                        "on maximum sum path");
        int sum = getMaxSum(tree.root,0);
        getMaxSumPath(tree.root, 0, sum, "");
        System.out.println("");
        System.out.println("Sum of nodes is : " + sum);
    }
}
