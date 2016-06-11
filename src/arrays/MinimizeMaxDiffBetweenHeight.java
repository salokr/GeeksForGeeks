package arrays;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 */
/*
                                                             TASK DESCRIPTION
Given heights of n towers and a value k. We need to either increase or decrease height of every tower by k (only once) where k > 0. The task is to minimize the difference between the heights of the longest and the shortest tower after modifications, and output this difference.
Examples:
Input  : arr[] = {1, 15, 10}, k = 6
Output : arr[] = {7, 9, 4}
         Maximum difference is 5.
Explanation : We change 1 to 6, 15 to 
9 and 10 to 4. Maximum difference is 5
(between 4 and 9). We can't get a lower
difference.
Input : arr[] = {1, 5, 15, 10} 
        k = 3   
Output : arr[] = {4, 8, 12, 7}
Maximum difference is 8
Input : arr[] = {4, 6} 
        k = 10
Output : arr[] = {14, 16} OR {-6, -4}
Maximum difference is 2
Input : arr[] = {6, 10} 
        k = 3
Output : arr[] = {9, 7} 
Maximum difference is 2
Input : arr[] = {1, 10, 14, 14, 14, 15}
        k = 6 
Output: arr[] = {7, 4, 8, 8, 8, 9} 
Maximum difference is 5
Input : arr[] = {1, 2, 3}
        k = 2 
Output: arr[] = {3, 4, 5} 
Maximum difference is 2
Source : Adobe Interview Experience | Set 24 (On-Campus for MTS)
*/
public class MinimizeMaxDiffBetweenHeight 
{
    public static void main(String[] args)
    {
        int a[]={7,4,8,8,8,9};
        System.out.println(arrangeArrays(a, 5));
    }
    public static int arrangeArrays(int a[],int k)
    {
        Arrays.sort(a);
        int n=a.length;
        int l=0,r=a.length-1;/* 7 10 9*/
        if(a[r]-a[l]<=k)
        {
            for(int i=0;i<n;i++)
                a[i]+=k;
            return (a[r]-a[l]);
        }//because as k is greater than (max-min), k must be very large than x and y and if we subtract or add we will increase diff only, DO ALGEBRA AND THINK !!!!
        a[l]+=k;//as expected first is minimum so we have to increase it
        a[r]-=k;//as consequence  max should be decreased
        int max=Util.getMax(a[r],a[l]);//keep track of max..... 
        int min=Util.getMin(a[r],a[l]);//and min
        for(int i=1;i<n-1;i++)
        {
            if(a[i]<min)//if this is the case we should move closer to max value otherwise........
                a[i]+=k;//subtracting only worse the situation
            else if(a[i]>max)//we should try to minimize the difference
                a[i]-=k;
            else// else in between max and min
            {
                if(max-a[i]>a[i]-min)//if a[i] is close to min increase it to move closer to max 
                    a[i]+=k;
                else a[i]-=k;// else move closer to min
            }
            max=Util.getMax(a[i],max);//keep track of max......... 
            min=Util.getMin(a[i],min);//and min
        }
        return max-min;//return the required difference :D :D :D
    }
}
