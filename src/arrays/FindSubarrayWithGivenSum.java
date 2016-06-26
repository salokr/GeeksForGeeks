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
Find subarray with given sum
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
*/
public class FindSubarrayWithGivenSum 
{
    public static void findSubArray(int a[],int k)
    {
        int sum=a[0],l=0;
        for(int i=1;i<a.length;i++)
        {
            
            if(sum<k)
                sum+=a[i];
            
            while(sum>k&&l<i)
            {
                sum-=a[l];
                l++;
            }
            //System.out.println(sum);
            if(sum==k)
            {
            //Solution is found 
                System.out.print((l+1)+" "+(i+1));
                return;
            }
            
            
            //System.out.println(sum);
        }
        //System.out.println(sum);
        System.out.print("-1");
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            findSubArray(a, k);
            System.out.println();
            t--;
        }
    }
}
