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
public class LargestPairSumInaSortedArray 
{
    public static void findMaxSum(int a[])
    {
        //solution is to find first max and second max
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>first)
            {
                second=first;
                first=a[i];
            }
            else if(a[i]>second)
                second=a[i];
        }
        System.out.println(first+" "+second+" "+(first+second));
    }
    public static void main(String[] args)
    {
        int a[]={12,10,6,40,34};
        findMaxSum(a);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
