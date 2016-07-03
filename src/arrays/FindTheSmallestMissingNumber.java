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
Find the smallest missing number
Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n.
Find the smallest number that is missing from the array.
Examples
Input: {0, 1, 2, 6, 9}, n = 5, m = 10
Output: 3
Input: {4, 5, 10, 11}, n = 4, m = 12
Output: 0
Input: {0, 1, 2, 3}, n = 4, m = 5
Output: 4
Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
Output: 8
*/
public class FindTheSmallestMissingNumber 
{
public static int findSmallestMissing(int a[])
{
    int i;
    if(a[0]!=0)
        return 0;
    for( i=0;i<a.length-1;i++)
        if(a[i+1]-a[i]>1)
            return i+1;
    return i+1;
}
public static void main(String[] args)
{
    int a[]= {0, 1, 2, 6, 9};
    int b[]={4, 5, 10, 11};
    int c[]={0, 1, 2, 3};
    int d[]={0, 1, 2, 3, 4, 5, 6, 7, 10};
    System.out.println(findSmallestMissing(a));
    System.out.println(findSmallestMissing(b));
    System.out.println(findSmallestMissing(c));
    System.out.println(findSmallestMissing(d));
}
}
