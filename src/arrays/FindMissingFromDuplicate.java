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

/*                                                                TASK DESCRIPTION

Find lost element from a duplicated array
Given two arrays which are duplicates of each other except one element, that is one element from one of the array is missing, we need to find that missing element.
Examples:
Input:  arr1[] = {1, 4, 5, 7, 9}
        arr2[] = {4, 5, 7, 9}
Output: 1
1 is missing from second array.

Input: arr1[] = {2, 3, 4, 5}
       arr2[] = {2, 3, 4, 5, 6}
Output: 6
6 is missing from first array.
*/
public class FindMissingFromDuplicate 
{
    public static void findMissingElement(int a[],int b[])
    {
        int sum1=Util.getSum(a);
        int sum2=Util.getSum(b);
        //System.out.println(sum1+" "+sum2);
        if(sum1==sum2&&a.length!=b.length)
            System.out.println(0);
        else if(a.length<b.length)
            System.out.println(sum2-sum1);
        else
            System.out.println(sum1-sum2);
    }
    public static void main(String[] args)
    {
        int a[]={2, 3, 4, 5},b[]={2, 3, 4, 5, 6};
        int c[]= {1, 4, 5, 7, 9},d[]={4, 5, 7, 9};
        findMissingElement(a, b);
        findMissingElement(c, d);
    }
}
