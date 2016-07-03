/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
/*
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

Examples:

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
*/
public class FindtheMaximum_j_Minus_i_SuchThatArr_j_GT_Arr_i
{
    public static void findMin(int a[])
    {
        NewBst bst=new NewBst();
        int answer[]=new int[a.length];
        for(int i=a.length-1;i>=0;i--)
            answer[i]=bst.add(a[i], i);
        //System.out.println(Arrays.toString(answer));
        int maxindex=Integer.MIN_VALUE;
        for(int i=0;i<answer.length;i++)
        {
            int currdiff;
            if(answer[i]==-1)
                currdiff=0;
            else currdiff=answer[i]-i;
            if(currdiff>maxindex)
                maxindex=currdiff;
        }
        System.out.println(maxindex);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<a.length;i++)
                a[i]=sc.nextInt();
            findMin(a);
            t--;
        }
    }
}
class Node_h
{
    int data;
    int index;
    int maxindex;
    Node_h left,right;
    public Node_h(int data,int index)
    {
        this.data=data;
        this.index=index;
        maxindex=-1;
        left=right=null;
    }
    @Override
    public String toString()
    {
        return ""+maxindex;
    }
}
class NewBst
{
    Node_h root;
    public int add(int x,int index)
    {
        Node_h current=root,parent=null;
        boolean found=false;
        int answer=-1;
        while(current!=null)
        {
            parent=current;
            if(x>current.data)
                current=current.right;
            else
            {
                if(x<current.data&&!found)
                {
                    answer=current.index;
                    found=true;
                }
                current=current.left;
            }
        }
        Node_h nnode=new Node_h(x, index);
        if(parent==null)
            root=nnode;
        else
        {
            if(parent.data<x)
                parent.right=nnode;
            else parent.left=nnode;
        }
        return answer;
    }
}