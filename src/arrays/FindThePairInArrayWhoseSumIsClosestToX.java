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

/*                                                              TASK DESCRIPTION
Given a sorted array and a number x, find the pair in array whose sum is closest to x
Given a sorted array and a number x, find a pair in array whose sum is closest to x.
Examples:
Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
A simple solution is to consider every pair and keep track of closest pair (absolute difference between pair sum and x is minimum). Finally print the closest pair. Time complexity of this solution is O(n2)
An efficient solution can find the pair in O(n) time
*/
public class FindThePairInArrayWhoseSumIsClosestToX 
{
    public static void findPair(int a[],int x)
    {
        int l=0,r=a.length-1,mindiff=Integer.MAX_VALUE,lpoint=-1,rpoint=-1;
        while(l<r)
        {
            int diff=Math.abs(a[l]+a[r]-x);
            if(diff<mindiff)
            {
                mindiff=diff;
                lpoint = l;
                rpoint=r;
            }
            if(x>a[l]+a[r])
                l++;
            else r--;
        }
        System.out.println(a[lpoint]+" "+a[rpoint]);
    }
    public static void main(String[] args)
    {
        int arr[] = {10, 22, 28, 29, 30, 40}, x = 54;
        findPair(arr, x);
        int arr2[] = {1, 3, 4, 7, 10}, x2 = 15;
        findPair(arr2, x2);
    }
}
/*
since array is sorted we need to keep track where the current sum is, if it is left of x, increase l else decrease r;
REMEMEBER HERE sum IS LIKE A POINT WHICH HAS TO BE BROUGHT NEAR TO x AS MUCH AS POSSIBLE 

*/