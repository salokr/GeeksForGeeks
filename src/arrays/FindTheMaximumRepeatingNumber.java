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
Find the maximum repeating number in O(n) time and O(1) extra space
Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n. 
Find the maximum repeating number in this array. 
For example, let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, 
the maximum repeating number would be 2. Expected time complexity is O(n) and extra space allowed is O(1). 
Modifications to array are allowed.
The naive approach is to run two loops, the outer loop picks an element one by one, 
the inner loop counts number of occurrences of the picked element. 
Finally return the element with maximum count. Time complexity of this approach is O(n^2).
*/

public class FindTheMaximumRepeatingNumber 
{
    public static void findMax(int a[],int k)
    {
        for(int i=0;i<a.length;i++)
            a[a[i]%k]+=k;
        int max=Integer.MIN_VALUE;
        for(int i:a)
            if(i>max)
                max=i;
        System.out.println("Max Occuring Element Is : "+max%k+" Occuring "+max/k+" times");
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
        findMax(arr, 10);
    }
}
