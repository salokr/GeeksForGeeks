/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
/*
Count smaller elements on right side
Write a function to count number of smaller elements on right of each element in an array. Given an unsorted array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of smaller elements on right side of each element arr[i] in array.
Examples:
Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
Output:  countSmaller[]  =  {6, 1, 1, 1, 0, 1, 0} 
(Corner Cases)
Input:   arr[] =  {5, 4, 3, 2, 1}
Output:  countSmaller[]  =  {4, 3, 2, 1, 0} 
Input:   arr[] =  {1, 2, 3, 4, 5}
Output:  countSmaller[]  =  {0, 0, 0, 0, 0}

*/
public class CountSmallerElementsOnRightSide 
{
//Mine idea is to count #f right side move done during insertion for each node while inserting from RHS of array, counting rhs guarantees that
//we are inserting greater elements,one thing is to note is that when we have element greater than root, 
//in that case just get count of LHS subtree
//and while moving to right justcount number of rhs move you make
//at time of insertion also store number of elements in subtree rooted at current node
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            BST bst=new BST();
            int count[]=new int[arr.length];
            for(int i=arr.length-1;i>=0;i--)
                count[i]=bst.add(arr[i]);
            for(int i:count)
                System.out.print(i+" ");
        }
    }
    

}
class BST// f***ing bst for this only
{
    Node root;
    public int add(int x)
    {
        Node current=root,parent=null;
        int count=0;
        while(current!=null)
        {
            current.numofnodes++;
            parent=current;
            if(x>current.data)
            {
                if(current.left!=null)
                    count+=current.left.numofnodes+1;
                current=current.right;
                count++;
            }
            else current=current.left;
            
        }
        Node n=new Node(x);
        if(parent==null)
            root=n;
        else
            if(x>parent.data)
                parent.right=n;
            else
                parent.left=n;
        n.answer=count;
        return n.answer;
    }
    public void inorder(Node current)
    {
        if(current==null)
            return;
        inorder(current.left);
        System.out.println(current.data+" "+current.numofnodes);
        inorder(current.right);
    }
    
}
class Node
{
    int answer;
    int data;
    Node left;
    Node right;
    int numofnodes;
    public Node(int n)
    {
        data=n;
        left=right=null;
        numofnodes=0;
        answer=0;
    }
}