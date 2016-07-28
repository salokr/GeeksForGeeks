/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ashutosh
 */
/*
Print level order traversal line by line
Given a binary tree, print level order traversal in a way that nodes of all levels are printed in separate lines.
For example consider the following tree
          1
       /     \
      2       3
    /   \       \
   4     5       6
        /  \     /
       7    8   9

Output for above tree should be
1
2 3
4 5 6
7 8 9
*/
public class PrintLevelOrderTraversalLineByLine
{
    public static void doLevelOrder(BinaryTree bt)
    {
        Queue<Node> q=new LinkedList<>();
        Node root=bt.root;
        if(root==null)
            return;
        q.add(root);
        int size=q.size(),current=0;
        while(!q.isEmpty())
        {
            if(current==size)
            {
                current=0;
                size=q.size();
                System.out.println();
            }
            current++;
            Node deq=q.remove();
            System.out.print(deq.data+" ");
            if(deq.left!=null)q.add(deq.left);
            if(deq.right!=null)q.add(deq.right);
        }
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.root=new Node(1);
        Node root=bt.root;
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        doLevelOrder(bt);
    }
}
