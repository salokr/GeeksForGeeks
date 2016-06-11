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

Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want. Return the maximum possbile of summation of i*arr[i].

Example:

Input: arr[] = {1, 20, 2, 10}
Output: 72
We can 72 by rotating array twice.
{2, 10, 1, 20}
20*3 + 1*2 + 10*1 + 2*0 = 72

Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
Output: 330
We can 330 by rotating array 9 times.
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
0*1 + 1*2 + 2*3 ... 9*10 = 330


*/


public class FindMaximumValueOfSumWithRotationsAllowedOnly 
{
    public static void findMaxSum(int a[])
    {
        int sum=0,maxsum=Integer.MIN_VALUE,currsum=0;
        for(int i=0;i<a.length;i++)
        {
            currsum+=i*a[i];
            sum+=a[i];
        }
        maxsum=currsum;
        int n=a.length;
        for(int i=1;i<=a.length;i++)
        {
            currsum+=sum-n*a[n-i];
            if(currsum>maxsum)
                maxsum=currsum;
        }
        System.out.println(maxsum);
    }
    public static void main(String[] args)
    {
        int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        findMaxSum(arr);
    }
}
