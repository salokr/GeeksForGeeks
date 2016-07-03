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
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Given an unsorted array arr[0..n-1] of size n, 
find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted.

Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program
should be able to find that the subarray lies between the indexes 3 and 8.
2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], 
your program should be able to find that the subarray lies between the indexes 2 and 5.
*/
public class LengthUnsortedSubarray
{
    public static void findSubarray(int a[])
    {
        int left=-1,right=-1;
        for(int i=0;i<a.length-1;i++)
        {
            if(a[i]>a[i+1])
            {
                left=i;
                break;
            }
        }
        for(int i=a.length-2;i>=0;i--)
        {
            if(a[i+1]<a[i])
            {
                right=i+1;
                break;
            }
        }
        int max=a[left],min=a[right];
        //System.out.println(left+" "+right);
        for(int i=left;i<=right;i++)
        {
            if(a[i]>max)
                max=a[i];
            if(a[i]<min)
                min=a[i];
        }
        for(int i=0;i<left;i++)
        {
            if(a[i]>min){left=i;
                break;}
        }
        for(int i=a.length-1;i>right;i--)
            if(a[i]<max){right=i;
                break;}
        System.out.println(left+ " "+right);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            findSubarray(a);
            t--;
        }
    }
}
