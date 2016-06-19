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
Rearrange positive and negative numbers in O(n) time and O(1) extra space
An array contains both positive and negative numbers in random order. 
Rearrange the array elements so that positive and negative numbers are placed alternatively.
Number of positive and negative numbers need not be equal. 
If there are more positive numbers they appear at the end of the array. 
If there are more negative numbers, they too appear in the end of the array.

For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

The solution is to first separate positive and negative numbers using partition process of QuickSort. 
In the partition process, consider 0 as value of pivot element so that all negative numbers are placed before positive numbers. 
Once negative and positive numbers are separated, we start from the first negative number and first positive number, 
and swap every alternate negative number with next positive number.
*/
public class RearrangePositiveandNegativeNumbers 
{
    public static void partitionArray(int a[])
    {
        int pivot=0;
        int j=-1;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>=pivot)
            {
                j++;
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int a[]={-1, 2, -3, 4, 5, 6, -7, 8, 9};
        partitionArray(a);
        int l=1,r=0;
        for(int i=0;i<a.length;i++)
            if(a[i]<0)
            {
                r=i;
                break;
            }
        //l now point to first +ve and r points to first negative elements
        int lboundary=r,rboundary=a.length;
        while(l<lboundary&&r<rboundary)
        {
            int temp=a[l];
            a[l]=a[r];
            a[r]=temp;
            l+=2;
            r+=1;
        }
        System.out.println(Arrays.toString(a));
    }
}
