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

Rearrange an array in maximum minimum form
Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value, second minimum value, third second max, fourth second min and so on.

Examples:

Input  : arr[] = {1, 2, 3, 4, 5, 6, 7} 
Output : arr[] = {7, 1, 6, 2, 5, 3, 4}

Input  : arr[] = {1, 2, 3, 4, 5, 6} 
Output : arr[] = {6, 1, 5, 2, 4, 3}
Expected time complexity is O(n).

*/

public class RearrangeInMaxMinForm 
{
    /*O(n) Extra Space*/
    public static void rearrange(int a[])
    {
        int n=a.length;
        int output[]=new int[n];
        Arrays.sort(a);
        int l=0,r=n-1;
        for(int i=0;i<a.length;i++)
        {
            if(i%2==0)//if even then pick max value and put at i
                output[i]=a[r--];
            else
                output[i]=a[l++];
        }
        Util.printArray(output);
    }
    public static void main(String[] args)
    {
        int a[]={7,1,6,2,5,3,4};
        rearrange(a);
    }
}
