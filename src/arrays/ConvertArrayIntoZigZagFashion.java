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
/*                                                          TASK DESCRIPTION
Convert array into Zig-Zag fashion
Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.

Example: 
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input:  arr[] =  {1, 4, 3, 2}
Output: arr[] =  {1, 4, 2, 3}
*/

public class ConvertArrayIntoZigZagFashion
{
    public static void zigZagForm(int a[])
    {
        int n=a.length;
        for(int i=1;i<n;i+=2)
        {
            int max=a[i]>a[i-1]?i:i-1;
            if(i+1<n)
                max=a[max]>a[i+1]?max:i+1;
            if(max!=i)
            {
            int temp=a[max];
            a[max]=a[i];
            a[i]=temp;
            }
        }
        Util.printArray(a);
    }
    public static void main(String[] args)
    {
        int arr1[] = {4, 3, 7, 8, 6, 2, 1};
        int arr2[] =  {1, 4, 3, 2};
        int arr3[] = {3, 7, 4, 8, 2, 6, 1};
        zigZagForm(arr3);zigZagForm(arr1);zigZagForm(arr2);
    }
}
