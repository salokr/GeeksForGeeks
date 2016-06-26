/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;

/**
 *
 * @author ashutosh
 */
/*
Find a sorted subsequence of size 3 in linear time
Given an array of n integers, 
find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time.
If there are multiple such triplets, then print any one of them.

Examples:

Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30

Input:  arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4

Input:  arr[] = {4, 3, 2, 1}
Output: No such triplet
Source: Amazon Interview Question

Hint: Use Auxiliary Space

Solution:
1) Create an auxiliary array smaller[0..n-1]. smaller[i] should
store the index of a number which is smaller than arr[i] and is on left side of arr[i]. 
smaller[i] should contain -1 if there is no such element.
2) Create another auxiliary array greater[0..n-1]. 
greater[i] should store the index of a number which is greater than arr[i] and is on right side of arr[i]. 
greater[i] should contain -1 if there is no such element.
3) Finally traverse both smaller[] and greater[] and find the index i for which both smaller[i] and greater[i] are not -1.
*/

public class FindASortedSubsequenceOfSize3InLinearTime 
{
    public static void findsubSequence(int a[])
    {
        int leftsmaller[]=new int[a.length];
        int nextgreater[]=new int[a.length];
        //store element less than current to the left in leftsmaller array---> O(n) Time
        //store element greater than current to right in nextgreater array---> O(n) Time
        leftsmaller[0]=-1;nextgreater[a.length-1]=-1;
        int last=a[0];
        for(int i=1;i<a.length;i++)
        {
            if(last>=a[i])
            {
                last=a[i];
                leftsmaller[i]=-1;
            }
            else
                leftsmaller[i]=last;
        }
        last=a[a.length-1];
        for(int i=a.length-2;i>=0;i--)
        {
            if(last<=a[i])
            {
                last=a[i];
                nextgreater[i]=-1;
            }
            else
                nextgreater[i]=last;
        }
        //System.out.println(Arrays.toString(leftsmaller)+Arrays.toString(nextgreater));
        for(int i=0;i<a.length;i++)
        {
            if(nextgreater[i]!=-1&&leftsmaller[i]!=-1)
            {
                System.out.println(leftsmaller[i]+" "+a[i]+" "+nextgreater[i]);
                return;
            }
        }
        System.out.println("No Such Sequence Found");
    }
    public static void main(String[] args)
    {
        int a[]={12, 11, 10, 5, 6, 2, 30};
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {4, 3, 2, 1};
        findsubSequence(a);
        findsubSequence(arr1);
        findsubSequence(arr2);
    }
}
