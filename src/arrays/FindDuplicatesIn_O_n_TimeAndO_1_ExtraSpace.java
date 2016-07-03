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
Find duplicates in O(n) time and O(1) extra space
Given an array of n elements which contains elements from 0 to n-1, 
with any of these numbers appearing any number of times. 
Find these repeating numbers in O(n) and using only constant memory space.
For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
This problem is an extended version of following problem.
*/
public class FindDuplicatesIn_O_n_TimeAndO_1_ExtraSpace
{
    public static void findDuplicates(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            int index=Math.abs(a[i]);
            if(a[index]<0)
            {
                System.out.println("Duplicate At "+i);
            }
            else
                a[index]=-a[index];
        }
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 1, 3, 6, 6,6};
        findDuplicates(arr);
    }
}
