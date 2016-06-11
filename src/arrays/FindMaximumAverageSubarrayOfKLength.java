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
                                                                TASK DESCRIPTION

Given an array with positive and negative numbers, find the maximum average subarray of given length.

Example:

Input:  arr[] = {1, 12, -5, -6, 50, 3}, k = 4
Output: Maximum average subarray of length 4 begins
        at index 1.
Maximum average is (12 - 5 - 6 + 50)/4 = 51/4

Approach 1 : Solution can be O(n), and can require O(n) auxiliary space.

Better Approach : Time complexity of the method should be O(n), and  it should require constant extra space.
*/

public class FindMaximumAverageSubarrayOfKLength 
{
    public static void findSubarray(int a[],int k)
    {
        int max,sum=0,n=a.length,goodindex;
        for(int i=0;i<k;i++)
            sum+=a[i];
        goodindex=k-1;
        max=sum;
        for(int i=k;i<n;i++)
        {
            sum+=a[i]-a[i-k];
            if(sum>max)
            {
                max=sum;
                goodindex=i-k+1;
            }
        }
        System.out.println("Maximum Sub-Array Starts At Position : "+goodindex);
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 12, -5, -6, 50, 3},k=4;
        findSubarray(arr, k);
    }
}
