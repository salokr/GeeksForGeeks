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
Find the closest pair from two sorted arrays
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.

We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x,
we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.

Example:

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32      
Output:  1 and 30

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 50      
Output:  7 and 40
*/

/*
Approach 1: Merge and find minimum differnece doing linear search,keep elements from different set only 
*/
public class FindtheclosestpairfromtwoSortedArrays 
{
    public static void findPairs(int a[],int b[],int x)
    {
        int mindiff=Integer.MAX_VALUE,lpos=-1,rpos=-1;
        int l=0,r=b.length-1;
        while(l<a.length&&r>=0)
        {
            int diff=Math.abs(a[l]+b[r]-x);
            if(diff<mindiff)
            {
                mindiff=diff;
                lpos=l;rpos=r;
            }
            if(a[l]+b[r]>x)
                r--;
            else l++;
        }
        System.out.println(a[lpos]+" "+b[rpos]);
    }
    public static void main(String[] arsg)
    {
       int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        findPairs(ar1, ar2, 32);
        
        int ar3[] = {1, 4, 5, 7};
        int ar4[] = {10, 20, 30, 40};
        findPairs(ar3, ar4, 50);
    }
}
