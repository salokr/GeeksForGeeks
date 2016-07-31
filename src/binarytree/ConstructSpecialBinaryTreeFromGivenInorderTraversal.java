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
Construct Special Binary Tree from given Inorder traversal
Given Inorder Traversal of a Special Binary Tree in 
which key of every node is greater than keys in left and right children, construct the Binary Tree and return root.
Examples:
Input: inorder[] = {5, 10, 40, 30, 28}
Output: root of following tree
         40
       /   \
      10     30
     /         \
    5          28 

Input: inorder[] = {1, 5, 10, 40, 30, 15, 28, 20}
Output: root of following tree
          40
        /   \
       10     30
      /         \
     5          28
    /          /  \
   1         15    20
The idea used in Construction of Tree from given Inorder and Preorder traversals can be used here. Let the given array is {1, 5, 10, 40, 30, 15, 28, 20}. The maximum element in given array must be root. The elements on left side of the maximum element are in left subtree and elements on right side are in right subtree.

         40
      /       \  
   {1,5,10}   {30,15,28,20}
We recursively follow above step for left and right subtrees, and finally get the following tree.

          40
        /   \
       10     30
      /         \
     5          28
    /          /  \
   1         15    20
Algorithm: buildTree()
1) Find index of the maximum element in array. The maximum element must be root of Binary Tree.
2) Create a new tree node ‘root’ with the data as the maximum value found in step 1.
3) Call buildTree for elements before the maximum element and make the built tree as left subtree of ‘root’.
5) Call buildTree for elements after the maximum element and make the built tree as right subtree of ‘root’.
6) return ‘root’.
*/
public class ConstructSpecialBinaryTreeFromGivenInorderTraversal 
{
    public static Node constructTree(int a[],int start,int end)
    {
        if(start>end)
            return null;
        int index=getMaxIndex(a, start, end);
        Node current=new Node(a[index]);
        current.left=constructTree(a, start, index-1);
        current.right=constructTree(a, index+1, end);
        return current;
    }
    public static int getMaxIndex(int a[],int start,int end)
    {
        int maxindex=start;
        for(int i=start+1;i<end;i++)
        {
            if(a[i]>a[maxindex])
                maxindex=i;
        }
        return maxindex;
    }
    public static void main(String args[]) 
    {
        BinaryTree tree = new BinaryTree();
         
        /* Assume that inorder traversal of following tree is given
             40
            /   \
          10     30
         /         \
        5          28 */
        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mynode =constructTree(inorder, 0, len - 1);
  
        /* Let us test the built tree by printing Inorder traversal */
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.inorder(mynode);
    }
}
