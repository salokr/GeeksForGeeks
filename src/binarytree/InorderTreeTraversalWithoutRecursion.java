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
/**
 *
 * Inorder Tree Traversal without Recursion
 * Using Stack is the obvious way to traverse tree without recursion. 
 * Below is an algorithm for traversing binary tree using stack. See this for step wise step execution of the algorithm.
1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
 */
public class InorderTreeTraversalWithoutRecursion
{
    public static void doInorder(BinaryTree bt)
    {
        Stack<Node> stk=new Stack<>();
        Node current=bt.root;
        while(true)
        {
            if(current!=null)
            {
                stk.push(current);
                current=current.left;
            }
            else
            {
                if(stk.isEmpty())
                    break;
                current=stk.pop();
                System.out.print(current.data+" ");
                current=current.right;
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        BinaryTree bt=new BinaryTree();
        bt.addSortedN(10);
        doInorder(bt);
        bt.inorder(bt.root);
    }
}
