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
Count Strictly Increasing Subarrays
Given an array of integers, count number of subarrays (of size more than one) that are strictly increasing.
Expected Time Complexity : O(n)
Expected Extra Space: O(1)

Examples:

Input: arr[] = {1, 4, 3}
Output: 1
There is only one subarray {1, 4}

Input: arr[] = {1, 2, 3, 4}
Output: 6
There are 6 subarrays {1, 2}, {1, 2, 3}, {1, 2, 3, 4}
                      {2, 3}, {2, 3, 4} and {3, 4}

Input: arr[] = {1, 2, 2, 4}
Output: 2
There are 2 subarrays {1, 2} and {2, 4}
*/
public class CountStrictlyIncreasingSubarray 
{
    public static void countSubArray(int a[])
    {
        int n=0,max=Integer.MIN_VALUE,count=1;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]>a[i-1])//if current is greater than previous element then we have increasing subarray
                count++;
            else
            {
                //here we have violated increasing subarray property need to reassign values
                n++;//increase number of subarrays
                if(count>max)
                    max=count;//keep track of largest such subarray
                count=1;//single element is always increasing
            }
        }
        System.out.println("Total Number Of Subarrays "+count+" And Largest Size Of Such Subarray is : "+max);
    }
    public static void main(String[] arsg)
    {
        int a[]={1, 2, 3, 4};
        countSubArray(a);
    }
}
