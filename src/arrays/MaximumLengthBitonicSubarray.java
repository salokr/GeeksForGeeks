/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author ashutosh
 */
/*
Maximum Length Bitonic Subarray
Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic 
if there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j]. 
Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
Expected time complexity of the solution is O(n)

Simple Examples
1) A[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5.

2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.

Extreme Examples
1) A[] = {10}, the single element is bitnoic, so output is 1.

2) A[] = {10, 20, 30, 40}, the complete array itself is bitonic, so output is 4.

3) A[] = {40, 30, 20, 10}, the complete array itself is bitonic, so output is 4.

Solution
Let us consider the array {12, 4, 78, 90, 45, 23} to understand the soultion.
1) Construct an auxiliary array inc[] from left to right such that inc[i] contains length of the nondecreaing subarray ending at arr[i].
For for A[] = {12, 4, 78, 90, 45, 23}, inc[] is {1, 1, 2, 3, 1, 1}

2) Construct another array dec[] from right to left such that dec[i] contains length of nonincreasing subarray starting at arr[i].
For A[] = {12, 4, 78, 90, 45, 23}, dec[] is {2, 1, 1, 3, 2, 1}.

3) Once we have the inc[] and dec[] arrays, all we need to do is find the maximum value of (inc[i] + dec[i] – 1).
For {12, 4, 78, 90, 45, 23}, the max value of (inc[i] + dec[i] – 1) is 5 for i = 3.

*/
public class MaximumLengthBitonicSubarray 
{
    public static void findMaxBitonic(int a[])
    {
        int increasing[]=new int[a.length];
        int decreasing[]=new int[a.length];
        increasing[0]=decreasing[a.length-1]=1;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]>a[i-1])
                increasing[i]=increasing[i-1]+1;
            else
                increasing[i]=1;
        }
        for(int i=a.length-2;i>=0;i--)
            if(a[i]>a[i+1])
                decreasing[i]=decreasing[i+1]+1;
            else decreasing[i]=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            int currsize=increasing[i]+decreasing[i]-1;
            if(currsize>max)
                max=currsize;
        }
        System.out.println("Max Size : "+max);
    }
    public static void main(String[] args)
    {
        int arr[] = {12, 4, 78, 90, 45, 23};
        findMaxBitonic(arr);
    }
}
/*50 More To Go*/