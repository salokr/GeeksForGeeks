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
Find the smallest and second smallest element in an array
Write an efficient C program to find smallest and second smallest element in an array.
Example:
Input:  arr[] = {12, 13, 1, 10, 34, 1}
Output: The smallest element is 1 and 
        second Smallest element is 10
*/
public class FindThesmallestAndSecondSmallestElementInAnArray
{
    public static void findNums(int a[])
    {
        int max=a[0],secmax=Integer.MIN_VALUE;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]>max)
            {
                secmax=max;
                max=a[i];
            }
            else if(a[i]>secmax)
                secmax=a[i];
        }
        System.out.println(max+" "+secmax);
    }
    public static void main(String[] args)
    {
        int arr[] = {12, 13, 1, 10, 34, 1};
        findNums(arr);
    }
}
