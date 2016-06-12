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
Smallest subarray with sum greater than a given value
Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}
*/
public class SmallestSubarrayWithSumGreaterThanaGivenValue
{
    public static void findSubarray(int a[],int k)
    {
        int n=a.length;
        int l=0,r=0,sum=a[0],minsize=n;
        while(r<n)
        {
            if(sum>k)
            {
                int currentsize=r-l+1;
                if(currentsize<minsize)
                    minsize=currentsize;
                sum-=a[l];
                l++;
            }
            else
            {
                r++;
                if(r+1<a.length)
                {
                sum+=a[r];
                }
            }
        }
        System.out.println(minsize);
    }
    public static void main(String[] args)
    {
        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        findSubarray(arr1, x);
        int arr2[] = {1, 10, 5, 2, 7};
        x  = 9;
        findSubarray(arr2, x);
        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        x  = 280;
        findSubarray(arr3, x);
    }
}
