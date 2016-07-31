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
Check if a given Binary Tree is SumTree
Write a function that returns true if the given Binary Tree is SumTree else false. 
A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. 
An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
*/
public class CheckIfAGivenBinarytreeissumTree
{
    public static boolean util(Node current, Sum s)
    {
        if(current==null)
        {
            s.sum=0;
            return true;
        }
        Sum leftsum=new Sum();Sum rightsum=new Sum();
        if(current.left==null&&current.right==null)
        {
            s.sum+=current.data;
            return true;
        }
        boolean left=util(current.left, leftsum);
        boolean right=util(current.right, rightsum);
        s.sum=leftsum.sum+rightsum.sum+current.data;
        System.out.print(s.sum+" ");
        return s.sum==2*current.data&&left&&right;
    }
    public static boolean isSumTree(Node current)
    {
        return util(current,new Sum());
    }
    public static void main(String[] args)
    {
        BinaryTree tree= new BinaryTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
  
        if(isSumTree(tree.root))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
/*
A more efficient solution would be to just note a TRICK :- Used above also but not in efficient way, if given tree is going to be
a sum tree then for nodes having non-leaf childs, value of current node will be equal to 2*(sum of childs) else if we have
a node with child which are leaves then, it will be simply equal to sum of them. 
Finally leaf and Empty nodes are valid Sum trees as given in question.
*/
class Sum
{
    int sum;
}